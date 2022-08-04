package com.hsartori.challenges.interviews.mathexpression.expressions.unary;

import com.hsartori.challenges.interviews.mathexpression.expressions.Expression;

import java.util.Map;

public class NegateExpression extends UnaryExpression {

    public NegateExpression(Expression expression) {
        super(expression);
    }

    @Override
    public double evaluate(Map<String, Double> arguments) {
        return -expression.evaluate(arguments);
    }

}
