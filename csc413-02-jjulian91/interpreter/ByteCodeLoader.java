/**
 * parses file and extracts bytecodes and args. stores them in arrayList and returns a
 * Program object
 *
 * @param byteSource reads in the bytecodes into buffered reader from file
 *
 * @author Jonathan Julian
 */
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.StringTokenizer;




public class ByteCodeLoader extends Object {


    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        ArrayList<ByteCode> byteTokens = new ArrayList<>();
        String lineRead;

        ByteCode bc;
        CodeTable.init();
        try{
            while ((lineRead = this.byteSource.readLine())!= null){ //gets new lines from buffered reader
                try{
                    ArrayList<String> byteArguments = new ArrayList<>();
                    //tokenizes first entry to get class
                    StringTokenizer codeType = new StringTokenizer(lineRead," ");
                    //creates class
                    Class<?> c = Class.forName("interpreter.bytecode."+(CodeTable.getClassName(codeType.nextToken())));

                    while(codeType.hasMoreTokens()){
                        //constructs args for
                        byteArguments.add(codeType.nextToken());
                    }
                    try{
                        //instantiates a bytecode object
                        bc = (ByteCode) c.getDeclaredConstructor().newInstance();
                        bc.init(byteArguments);
                        byteTokens.add(bc);
                    }
                    catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                            InstantiationException n){
                        System.out.println("Errror*: Method, Access, Target, Instantiation "+n.toString()+"\n");
                    }
                }
                catch (ClassNotFoundException c){
                    System.out.println("Error*: Class not found "+c.toString()+"\n");
                }
            }
        }
        catch(IOException e){
            System.out.println("ERROR*: IOException "+e.toString());
        }
        Program runningProgram = new Program(byteTokens);
        runningProgram.resolveAddrs();
        return runningProgram;
    }
}
