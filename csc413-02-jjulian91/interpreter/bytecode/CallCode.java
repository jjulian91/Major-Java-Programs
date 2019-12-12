package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends BranchInterface {
    private ArrayList<Integer> arg;

    @Override
    public void execute(VirtualMachine codes) {
        codes.updateReturnAdrs();
        codes.updatePC(getPCAddress());
        if(codes.getStackSize()>0)
            arg = codes.getTopFrame();
    }

    @Override
    public void init(ArrayList<String> args) {
        setBranchName(args.get(0));
    }


    @Override
    public String toString() {
        if(getBranchName().contains("<<") && arg!=null){
        String methodCall = getBranchName().substring(0,getBranchName().indexOf("<<"));
        return  CodeTable.getCodeName(getClass().toString()) +" "+ getBranchName()+" "+methodCall
                +"("+arg.toString()+")"+"\n";
        }
        else{return  CodeTable.getCodeName(getClass().toString()) +" "+ getBranchName()+"\n";}
    }
}
