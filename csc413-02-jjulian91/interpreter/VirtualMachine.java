package interpreter;
/**
 * Controller for RuntimeStack. All commands to RTS will be ran through here.
 * @param program Maintains the the ProgramCounter for all commands in the program.
 * @param runStack is controller for runTimeStack for all params passed in
 * @param isRunning is a flag to determine when to terminate the program
 * @param isDumping determines what to print out to screen.
 * @param returnAddrs hold all jump program counters for return
 * @param pc is current array element in the program for processing.
 * @author Jonathan Julian
 */
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDumping;

    protected VirtualMachine(Program program) {
        this.program = program;
    }


    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        isDumping = false;
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(isDumping){
                if(!(code instanceof DumpCode))
                System.out.print(code.toString());
                runStack.dump();
            }
            pc++;
        }
    }

    /**
     * sets isRunning Flag to false
     */
    public void terminateProgram(){
        isRunning=false;
    }

    /**
     *  pops top element of RTS
     * @return value popped
     */
    public int popStack(){
        return runStack.pop();
    }

    /**
     * removes top element
     * pops top frame from RTS
     * adds popped element to top of next stack
     */
    public void popFrame(){
        runStack.popFrame();
    }

    /**
     * adds item to top of stack
     * @param value
     */
    public void pushToStack(int value){
        runStack.push(value);
    }

    /**
     * peeks top element
     * @return top element
     */
    public int getTop(){
        if(runStack.getSize()>0)
        return runStack.peek();
        else{return 0;}
    }

    /**
     * sets dump flag off
     */
    public void dumpOff(){isDumping = false;}

    /**
     * sets dump flag on
     */
    public void dumpOn(){isDumping = true;}

    /**
     * sets new frame
     * @param offset from the top of current frame.
     */
    public void moveFrame(int offset){
    runStack.newFrameAt(offset);
    }

    /**
     * pushes current PC to returnAddrs, allows for reference on return
     */
    public void updateReturnAdrs(){
        returnAddrs.push(pc);
    }

    /**
     * moves PC to newPC
     * @param newPC
     */
    public void updatePC(int newPC){
        if(newPC < program.getSize())
        this.pc = newPC;
    }

    /**
     * gets top PC from ruturnAddrs
     */
    public void returnPC(){
        if(!returnAddrs.isEmpty())
        pc = returnAddrs.pop();
    }

    /**
     * loads
     * @param offset from bottom of current frame
     * into top of stack
     */
    public void load(int offset){
        runStack.load(offset);
    }

    /**
     * takes top of stack and stores
     * @param offset
     * from bottom of current frame
     */
    public void store(int offset){
        runStack.store(offset);
    }

    /**
     * get size of current RTS
     * @return current size
     */
    public int getStackSize(){
        return runStack.getSize();
    }

    /**
     * gets size of top frame
     * @return size of frame
     */
    public int getFrameSize(){return runStack.getFrame();}

    public ArrayList<Integer> getTopFrame(){
        return runStack.getTopFrame();
    }
}
