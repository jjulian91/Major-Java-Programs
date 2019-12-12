package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode implements ByteCode {

    private int levels = 0;
    @Override
    public void execute(VirtualMachine codes) {
        int tempLevels = levels;
        if(levels > codes.getFrameSize())
            tempLevels = codes.getFrameSize()+1;
        for (int i = 0; i < tempLevels; i++){
            codes.popStack();
        }

    }

    @Override
    public void init(ArrayList<String> args) {
    levels = Integer.parseInt(args.get(0));
    }

    @Override
    public String toString() {
        return  CodeTable.getCodeName(getClass().toString()) +" "+ levels +"\n";
    }
}
