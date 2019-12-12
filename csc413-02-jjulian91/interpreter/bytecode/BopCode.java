package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.Operand;
import interpreter.VirtualMachine;
import interpreter.operators.Operator;

import java.util.ArrayList;

public class BopCode implements ByteCode {

    private String operator;
    @Override
    public void execute(VirtualMachine codes) {
        Operand op2 = new Operand(codes.popStack());
        Operand op1 = new Operand(codes.popStack());
        Operator opType = Operator.getOperator(this.operator);
        Operand result = opType.execute(op1,op2);
        codes.pushToStack(result.getValue());
    }

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }


    @Override
    public String toString() {
        return  CodeTable.getCodeName(getClass().toString()) + " " + operator + '\n';
    }
}
