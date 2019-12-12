/**
 * @param program holds all the bytecode objects for processing.
 *
 * @author Jonathan Julian
 */


package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program(ArrayList<ByteCode> bytesLoaded) {
        program = bytesLoaded;
    }

    /**
     *
     * @param pc element in the program ArrayList
     * @return the bytecode stored at that address
     */
    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        ArrayList<BranchInterface> branches = new ArrayList<>();
        ArrayList<LabelCode> location = new ArrayList<>();

        for (int i = 0; i<program.size();i++) {
            ByteCode code = program.get(i);
            if(code instanceof BranchInterface){ //creates list of branches
                if(code instanceof LabelCode){
                    LabelCode label = (LabelCode) code;
                    label.setPCAddress(i);
                    location.add(label);
                }
                else{
                    BranchInterface branch = (BranchInterface) code;
                    branches.add(branch);
                }
            }
        }
        for (BranchInterface branchCode:branches) {//iterates branches to resolve addresses
            for (LabelCode label : location) {
                if (branchCode.getBranchName().equals(label.getBranchName()))
                    branchCode.setPCAddress(label.getPCAddress());
            }
        }
    }
}

