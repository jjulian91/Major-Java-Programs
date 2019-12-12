package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends BranchInterface {

    @Override
    public void execute(VirtualMachine codes) {
        if(codes.popStack()==0){
            codes.updatePC(getPCAddress());
        }
    }

    @Override
    public void init(ArrayList<String> args) {
        setBranchName(args.get(0));
    }


    @Override
    public String toString() {
        return  CodeTable.getCodeName(getClass().toString()) +" "+ getBranchName()+"\n";
    }
}

