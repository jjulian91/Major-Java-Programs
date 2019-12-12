/**
 * class for creating and maintaining RunTimeStack (RTS) and FramePointer
 * @param runTimeStack holds all arguments for the program
 * @param framePointer holds list of the start of all frames which in turn addresses to the RTS array
 *
 * @Author Jonathan Julian
 */


package interpreter;

import java.lang.reflect.Array;
import java.util.*;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    private int frameRef;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<Integer>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.push(0);
    }

    /**
     * Creates framePointer Iterator,  uses this to iterate over all entries in the
     * RTS.  Prints all elements separated by frames.
     */

    public void dump() {
        ListIterator<Integer> frameList = framePointer.listIterator();
        int start = 0, currentFrameEnd = 0;
        if(runTimeStack.size()==0){
            while(frameList.hasNext()){
                System.out.print("[]");
                frameList.next();
            }
        }
        else {
            frameList.next(); //eat main 0

            while (start < runTimeStack.size()) {
                start = currentFrameEnd;
                if (frameList.hasNext()) {
                    currentFrameEnd = frameList.next();
                } else {
                    currentFrameEnd = runTimeStack.size();
                }
                System.out.print("[");
                while (start < currentFrameEnd) {
                    System.out.print(runTimeStack.get(start));
                    if (start < currentFrameEnd - 1)
                        System.out.print(",");
                    start++;
                }
                System.out.print("]");
            }
        }
        System.out.println();
    }

    /**
     * checks for top value of rts, does not remove
     * @return item at top of RTS
     */
    public int peek(){
        int returnVal = 0;
        try {
            returnVal = runTimeStack.get(runTimeStack.size() - 1);
        }
        catch(EmptyStackException e){
            System.out.println("Stack Is empty");
        }
        return returnVal;
    }

    /**
     * removes top element of RTS
     *
     * @return value popped off stack
     */
    public int pop(){
        int returnVal = 0;
        try {
            returnVal = runTimeStack.remove(runTimeStack.size() - 1);
        }
        catch(EmptyStackException e){
            System.out.println("Stack Is empty");
        }
        return returnVal;
    }

    /**
     * adds a new frame to the pointer.
     * creates a new frame in the RuntimeStack class. The
     * parameter offset is used to denote how many slots down
     * from the top of RuntimeStack for starting a new frame.
     * @param offset
     */
    public void newFrameAt(int offset){
        if((runTimeStack.size()-offset) >= 0) //check out of bounds
            framePointer.push(runTimeStack.size()-offset);
    }

    /**
     * removes all RTS down to top element of StackPointer, pops stack pointer.
     *   we pop the top frame when we return from a function.
     *   Before popping, the function’s return value is at the
     *   top of the stack, so we’ll save the value, then pop the
     *   top frame and then push the return value back onto the
     *   stack. It is assumed return values are at the top of
     *   the stack.
     */
    public void popFrame(){

        if(framePointer.size()>1){
            Integer returnValue = pop();
            int size = runTimeStack.size();
            for(int i = framePointer.pop(); i < size;i++){
                pop();
        }
        push(returnValue);}
    }
    public ArrayList<Integer> getTopFrame(){
        ArrayList <Integer> frame = new ArrayList<>();
        int frameBound = framePointer.peek();
        for(int i = runTimeStack.size()-1; i >= frameBound ; i--){
            frame.add(runTimeStack.get(i));
        }

        return frame;
    }

    /**
    * STORE N <id> - pop the top of the stack; store
    * the value into the offset n from the start of the
    * frame; <id> is used as a comment and for dumping,
    * it’s the variable name where the data is stored.
    */
    public int store(int offset){
        int returnedValue = runTimeStack.remove(runTimeStack.size()-1);
        if(!framePointer.isEmpty())
            frameRef = framePointer.peek();
        if(frameRef+offset<runTimeStack.size()-1)
            runTimeStack.set(frameRef+offset,returnedValue);
        return returnedValue;
    }

    /**
     *  LOAD n <id> ; push the value in the slot which is offset n from the
     *  start of the frame onto the top of the stack;
     *  <id> is used as a comment and for dumping, it’s the
     *  variable name where the data is loaded.
     * @param offset N values from start of frame
     * @return return value added to RTS
     */
    public int load(int offset){
        frameRef = framePointer.peek();
        int value = runTimeStack.get(runTimeStack.size()-1);
        if((frameRef+offset) < runTimeStack.size()-1){
            try{
                value = runTimeStack.get(frameRef+offset);}
            catch (IndexOutOfBoundsException |EmptyStackException e){
                System.out.println(e);
            }
        }
        return push(value);//value loaded
    }

    /**
     * pushes element to top of RTS
     *
     * @param val number to push
     * @return returns number added to RTS
     */
    public Integer push(Integer val){
        runTimeStack.add(val);
        return val;
    }

    /**
     * gets current size of RTS.
     */

    public int getSize(){
        return runTimeStack.size();
    }

    /**
     * checks for frame size
     * @return size of top frame.
     */
    public int getFrame(){
        return runTimeStack.size()-1-framePointer.peek();
    }

}
