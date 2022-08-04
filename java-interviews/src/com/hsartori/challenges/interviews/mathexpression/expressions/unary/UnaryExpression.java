package com.hsartori.challenges.interviews.mathexpression.expressions.unary;

import com.hsartori.challenges.interviews.mathexpression.expressions.Expression;

public abstract class UnaryExpression implements Expression {
    protected Expression expression;

    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }
}
