package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;


public class StoreCode extends LoadStoreInterface{


    @Override
    public void execute(VirtualMachine codes) {
        codes.store(getValue());
    }

    @Override
    public String toString() {
        return  CodeTable.getCodeName(getClass().toString()) +" "+ getValue()+" "+getVar()+"   int "+getVar()+ " = "+
                getValue()+"\n";
    }
}
