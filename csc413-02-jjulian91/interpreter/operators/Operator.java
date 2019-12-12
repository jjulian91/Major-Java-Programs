package interpreter.operators;




import interpreter.Operand;

import java.util.HashMap;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.
    // ALL subclasses of operator MUST be in their own file.
    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );

    private static HashMap<String, Operator> operators;
    static{
        operators= new HashMap<>();
        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
        operators.put("/", new DivideOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("^", new PowerOperator());
        operators.put("(", new OpenOperator());
        operators.put(")", new CloseOperator());
        operators.put(">=", new GreaterEqual());
        operators.put(">", new Greater());
        operators.put("<=", new LessEqual());
        operators.put("<", new Less());
        operators.put("==", new Equals());
        operators.put("&", new And());
        operators.put("|", new Or());

    }

    
    public abstract int priority();
    public abstract Operand execute(Operand op1, Operand op2 );


    /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     * for example token.equals("+") and so on.
     * Think about what happens if we add more operators.
     */
    public static boolean check( String token ) {
        String operator[] = {"+","-","/","*","^","(",")", "<=", ">=","==",">","<","&","|"};
        for (String op : operator){
            if(token.equals(op)){
                return true;
            }
        }
        return false;
    }


    public static Operator getOperator(String token){
        return  operators.get(token);
    }
}
