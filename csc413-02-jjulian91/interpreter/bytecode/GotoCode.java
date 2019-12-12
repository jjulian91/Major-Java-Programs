package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends BranchInterface {

    @Override
    public void execute(VirtualMachine codes) {
        codes.updatePC(getPCAddress());
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
