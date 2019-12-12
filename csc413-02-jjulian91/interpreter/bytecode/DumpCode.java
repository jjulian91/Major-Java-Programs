package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode implements ByteCode{

    private Boolean status = false;
    @Override
    public void execute(VirtualMachine codes) {
        if(!status)
            codes.dumpOff();
        else{codes.dumpOn();}

    }

    @Override
    public void init(ArrayList<String> args) {
    if(args.get(0).equals("ON"))
        status = true;
    }


    @Override
    public String toString() {
        return "DUMP FAIL\n";
    }
}
