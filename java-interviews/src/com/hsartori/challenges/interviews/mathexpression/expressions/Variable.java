package com.hsartori.challenges.interviews.mathexpression.expressions;

import com.hsartori.challenges.interviews.mathexpression.exceptions.VariableNotFoundException;

import java.util.Map;

public class Variable implements Expression {

    protected String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> arguments) {
        final Double val = arguments.get(name);
        if (val == null) throw new VariableNotFoundException(name);
        return val;
    }

}
