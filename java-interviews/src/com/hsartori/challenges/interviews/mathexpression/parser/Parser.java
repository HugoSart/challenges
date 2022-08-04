package com.hsartori.challenges.interviews.mathexpression.parser;

import com.hsartori.challenges.interviews.mathexpression.expressions.Expression;
import com.hsartori.challenges.interviews.mathexpression.expressions.Operations;
import com.hsartori.challenges.interviews.mathexpression.expressions.Values;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Parser {

    public Expression parse(String expression) {
        return parse(tokenize(expression));
    }

    private Expression parse(List<Token> tokens) {
        System.out.println("Evaluating: " + tokens);

        final Stack<Token> opStack = new Stack<>();
        final Stack<Token> valStack = new Stack<>();
        Expression exp1 = null;
        while (!tokens.isEmpty()) {
            final Token token = tokens.remove(0);
            if (token.isOpeningParenthesis()) {
                if (opStack.isEmpty()) {
                    exp1 = parse(tokens);
                } else {
                    exp1 = Operations.ofBinary(opStack.pop(), exp1, parse(tokens));
                }
            } else if (!token.isClosingParenthesis()) {
                if (token.isNumber() || token.isVariable()) {
                    valStack.add(token);
                } else {
                    opStack.add(token);
                }
            } else {
                break;
            }
        }

        // Build expression
        // TODO: Unary expressions not working
        Expression last = exp1;
        if (valStack.size() == 1 && opStack.isEmpty()) {
            last = Values.of(valStack.pop());
        } else {
            while (!opStack.isEmpty()) {
                if (last == null && valStack.size() == 1) {
                    final Expression val = Values.of(valStack.pop());
                    last = opStack.isEmpty() ? val : Operations.ofUnary(opStack.pop(), val);
                } else {
                    final Expression val1 = last == null ? Values.of(valStack.pop()) : last;
                    final Expression val2 = Values.of(valStack.pop());
                    last = Operations.ofBinary(opStack.pop(), val2, val1);
                }
            }
        }

        // Join expressions
        return last;

    }

    private List<Token> tokenize(String expression) {
        expression = "(" + expression.trim().replaceAll(" ", "") + ")";
        final List<Token> tokens = new LinkedList<>();
        Token last = null;
        for (char c : expression.toCharArray()) {
            Token token = new Token(c);

            // Try to append
            if (last != null) {
                try {
                    token = last.append(token);
                } catch (IllegalStateException e) {
                    tokens.add(last);
                }
            }

            last = token;

        }
        tokens.add(last);
        return tokens;
    }

}
