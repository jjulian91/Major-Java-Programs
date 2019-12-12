package interpreter.bytecode;

import interpreter.CodeTable;
import interpreter.VirtualMachine;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadCode implements ByteCode {
    private Scanner userInput = new Scanner(System.in);

    private boolean incorrect = true;
    @Override
    public void execute(VirtualMachine codes) {
        int input = 0;
        do{
        try {
            System.out.println("Please enter an integer");
            input = Integer.parseInt(userInput.next());
            incorrect = false;
            }
        catch (InputMismatchException | NumberFormatException e){
            System.out.println("Please only enter an integer value");
            }
        }
        while(incorrect);
        //push int to stack
        codes.pushToStack(input);
    }

    @Override
    public void init(ArrayList<String> args) {

    }

    public String toString() {
        return  CodeTable.getCodeName(getClass().toString()) +"\n";
    }
}
