package com.hsartori.challenges.interviews.mathexpression.expressions;

import com.hsartori.challenges.interviews.mathexpression.parser.Token;

public class Values {

    public static Expression of(final Token token) {
        if (token.isNumber()) return new Const(Double.parseDouble(token.getToken()));
        if (token.isVariable()) return new Variable(token.getToken());
        throw new IllegalStateException("Token " + token + " is not a valid value expression.");
    }

}
