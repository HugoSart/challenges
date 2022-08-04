package com.hsartori.challenges.interviews.mathexpression.expressions;

import com.hsartori.challenges.interviews.mathexpression.expressions.binary.*;
import com.hsartori.challenges.interviews.mathexpression.expressions.unary.AbsExpression;
import com.hsartori.challenges.interviews.mathexpression.expressions.unary.NegateExpression;
import com.hsartori.challenges.interviews.mathexpression.expressions.unary.UnaryExpression;
import com.hsartori.challenges.interviews.mathexpression.parser.Token;

public class Operations {

    public static UnaryExpression ofUnary(final Token token, final Expression v) {
        if (Token.OP_ABS.equals(token)) return new AbsExpression(v);
        if (Token.OP_SUB.equals(token)) return new NegateExpression(v);
        throw new IllegalArgumentException("Token " + token + " is not a valid unary expression.");
    }

    public static BinaryExpression ofBinary(final Token token, final Expression v1, final Expression v2) {
        if (Token.OP_SUM.equals(token)) return new SumExpression(v1, v2);
        if (Token.OP_SUB.equals(token)) return new SubExpression(v1, v2);
        if (Token.OP_MUL.equals(token)) return new MulExpression(v1, v2);
        if (Token.OP_DIV.equals(token)) return new DivExpression(v1, v2);
        throw new IllegalArgumentException("Token " + token + " is not a valid binary expression.");
    }

}
