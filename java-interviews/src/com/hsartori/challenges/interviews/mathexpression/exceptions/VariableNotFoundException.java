package com.hsartori.challenges.interviews.mathexpression.exceptions;

public class VariableNotFoundException extends RuntimeException {

    public VariableNotFoundException(String name) {
        super("Variable " + name + " not found.");
    }
}
