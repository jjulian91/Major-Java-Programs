package interpreter.operators;


import interpreter.Operand;

public class DivideOperator extends Operator {
    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {

        if(op2.getValue() == 0)
            throw new IllegalArgumentException("Divide by 0");
        else{
        int result = op1.getValue() / op2.getValue();
            return new Operand(result);
        }
    }
}
