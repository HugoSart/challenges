package com.hsartori.challenges.interviews.mathexpression.parser;

import java.util.*;

public class Token {

    // Operation tokens
    public static final Token OP_ABS = new Token("abs");
    public static final Token OP_SUM = new Token("+");
    public static final Token OP_SUB = new Token("-");
    public static final Token OP_MUL = new Token("*");
    public static final Token OP_DIV = new Token("/");
    public static final Set<Token> OPERATIONS = Set.of(OP_SUM, OP_SUB, OP_MUL, OP_DIV, OP_ABS);

    // Symbol tokens
    public static final Token OPENING_PARENTHESIS = new Token("(");
    public static final Token CLOSING_PARENTHESIS = new Token(")");
    public static final Set<Token> PARENTHESIS = Set.of(OPENING_PARENTHESIS, CLOSING_PARENTHESIS);

    // Properties
    private final String token;

    public Token(String token) {
        this.token = token;
    }

    public Token(char token) {
        this.token = Character.toString(token);
    }

    public String getToken() {
        return token;
    }

    public boolean isOperation() {
        return OPERATIONS.contains(this);
    }

    public boolean isParenthesis() {
        return PARENTHESIS.contains(this);
    }

    public boolean isOpeningParenthesis() {
        return this.equals(OPENING_PARENTHESIS);
    }

    public boolean isClosingParenthesis() {
        return this.equals(CLOSING_PARENTHESIS);
    }

    public boolean isNumber() {
        if (token.equals(".")) {
            return true;
        } else {
            try {
                Double.parseDouble(token);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    public boolean isVariable() {
        return !this.equals(OP_ABS) && Character.isLetter(token.charAt(0));
    }

    public boolean isAppendable() {
        return isNumber() || isVariable();
    }

    public Token append(final Token other) {
        if (!(isAppendable() && other.isAppendable()) || (isNumber() && !other.isNumber())) {
            throw new IllegalStateException("Token " + token + " is not appendable with " + other);
        }
        return new Token(token + other.token);
    }

    @Override
    public String toString() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token1 = (Token) o;
        return Objects.equals(token, token1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

}
