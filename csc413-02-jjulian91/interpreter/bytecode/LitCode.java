package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;


public class LitCode extends LoadStoreInterface  {

    @Override
    public void execute(VirtualMachine codes) {
        codes.pushToStack(getValue());
    }

    @Override
    public String toString() {

        if(getVar()!=null){
        return  CodeTable.getCodeName(getClass().toString()) +" "+ getValue()+" "+getVar()+
                "    int "+getVar() +" = "+getValue()+"\n";}
        else{return  CodeTable.getCodeName(getClass().toString()) +" "+ getValue()+"\n";}
    }

}
