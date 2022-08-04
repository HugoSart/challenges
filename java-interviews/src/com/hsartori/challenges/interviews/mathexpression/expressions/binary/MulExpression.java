package com.hsartori.challenges.interviews.mathexpression.expressions.binary;

import com.hsartori.challenges.interviews.mathexpression.expressions.Expression;

import java.util.Map;

public class MulExpression extends BinaryExpression {

    public MulExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(Map<String, Double> arguments) {
        return left.evaluate(arguments) * right.evaluate(arguments);
    }
}
