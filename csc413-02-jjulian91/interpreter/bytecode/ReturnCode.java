package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode implements ByteCode {
    private String currentFunc;
    private String shortName;
    private Integer retVal;
    @Override
    public void execute(VirtualMachine codes) {
        codes.popFrame();
        retVal = codes.getTop();
        codes.returnPC();
    }

    @Override
    public void init(ArrayList<String> args) {
        if(args.size()>=1) {
            currentFunc = args.get(0);
            shortName = currentFunc.substring(0,currentFunc.indexOf("<<"));
        }
    }

    @Override
    public String toString() {
        if(currentFunc != null)
        return  CodeTable.getCodeName(getClass().toString()) +" "+ currentFunc + "  exit "+shortName+ " : "+retVal+"\n";
        else{return CodeTable.getCodeName(getClass().toString())+"\n";}
    }
}
