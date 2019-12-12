package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode implements ByteCode {

    @Override
    public void execute(VirtualMachine codes) {
        codes.terminateProgram();
    }

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public String toString() {
        return  CodeTable.getCodeName(getClass().toString()) + "\n";
    }
}
