package com.hsartori.challenges.interviews.mathexpression.expressions.binary;

import com.hsartori.challenges.interviews.mathexpression.expressions.Expression;

import java.util.Map;

public class DivExpression extends BinaryExpression {

    public DivExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(Map<String, Double> arguments) {
        return left.evaluate(arguments) / right.evaluate(arguments);
    }
}
