package interpreter.operators;

import interpreter.Operand;

public class And extends Operator {
    @Override
    public int priority() {
        return 0;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        if(op1.getValue() == 1 && op2.getValue() == 1)
            return new Operand(1);
        else{return new Operand(0);}

    }
}
