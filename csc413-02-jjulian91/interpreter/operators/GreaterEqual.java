package interpreter.operators;

import interpreter.Operand;

public class GreaterEqual extends Operator {
    @Override
    public int priority() {
        return 0;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        if(op1.getValue() >= op2.getValue())
            return new Operand(1);
        else {return new Operand(0);}
    }
}
