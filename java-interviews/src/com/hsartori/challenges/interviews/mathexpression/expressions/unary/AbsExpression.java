package com.hsartori.challenges.interviews.mathexpression.expressions.unary;

import com.hsartori.challenges.interviews.mathexpression.expressions.Expression;

import java.util.Map;

public class AbsExpression extends UnaryExpression {

    public AbsExpression(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate(Map<String, Double> arguments) {
        return Math.abs(expression.evaluate(arguments));
    }

}
