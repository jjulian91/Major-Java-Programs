package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

 public interface ByteCode {
     void execute(VirtualMachine codes);
     void init(ArrayList<String> args);

     String toString();
}
