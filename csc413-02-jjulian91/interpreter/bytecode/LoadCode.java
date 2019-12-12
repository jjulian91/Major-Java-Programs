package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends LoadStoreInterface {
    private String name = "LOAD";

    @Override
    public void execute(VirtualMachine codes) {
        codes.load(getValue());
    }

    @Override
    public String toString() {
        return  CodeTable.getCodeName(getClass().toString()) +" "+ getValue()+" "+getVar()+" <load "+getVar()+ ">\n";
    }
}
