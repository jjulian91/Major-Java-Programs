package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends BranchInterface {

    @Override
    public void execute(VirtualMachine codes) {    }

    @Override
    public void init(ArrayList<String> args) {
        setBranchName(args.get(0));
    }

    @Override
    public String toString() {
        return CodeTable.getCodeName(getClass().toString())+" "+getBranchName()+"\n";
    }


}

