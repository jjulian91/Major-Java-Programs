package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode implements ByteCode {

    private int offset = 0;
    @Override
    public void execute(VirtualMachine codes) {
        if(offset>=0)
            codes.moveFrame(offset);
    }

    @Override
    public void init(ArrayList<String> args) {
    offset = Integer.parseInt(args.get(0));
    }


    @Override
    public String toString() {
        return CodeTable.getCodeName(getClass().toString()) + " " + offset + '\n';
    }
}
