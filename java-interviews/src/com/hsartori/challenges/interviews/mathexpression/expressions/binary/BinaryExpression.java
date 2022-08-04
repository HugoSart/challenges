package com.hsartori.challenges.interviews.mathexpression.expressions.binary;

import com.hsartori.challenges.interviews.mathexpression.expressions.Expression;

public abstract class BinaryExpression implements Expression {
    public Expression left;
    public Expression right;

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

}
