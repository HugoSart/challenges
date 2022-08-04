package com.hsartori.challenges.interviews.mathexpression.expressions;

import java.util.Map;

public class Const implements Expression {

    protected double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Double> arguments) {
        return value;
    }

}
