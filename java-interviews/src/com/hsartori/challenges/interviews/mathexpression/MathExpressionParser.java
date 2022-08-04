package com.hsartori.challenges.interviews.mathexpression;

import com.hsartori.challenges.interviews.mathexpression.parser.Parser;

import java.util.Map;

public class MathExpressionParser {

    public static void main(String[] args) {
        final Parser parser = new Parser();
        System.out.println(parser.parse("-2 + 3")
                .evaluate(Map.of("a", 1.0)));
    }

}
