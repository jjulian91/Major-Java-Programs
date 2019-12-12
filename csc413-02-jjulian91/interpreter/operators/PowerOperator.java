package interpreter.operators;

import interpreter.Operand;


public class PowerOperator extends Operator {
    @Override
    public int priority() {
        return 3;
    }


    public Operand execute(Operand op1, Operand op2) {
        if(op2.getValue()==0){
         return new Operand(1);}
        int result = op1.getValue();

        for(int i = op2.getValue(); i > 1; --i){
            result *= op1.getValue();
            }
        return new Operand(result);

    }
}
