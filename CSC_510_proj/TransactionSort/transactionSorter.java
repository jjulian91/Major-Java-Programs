package TransactionSort;
import java.io.IOException;


public class transactionSorter {
    private Separator transactionSeparator;

    private transactionSorter(String transactions){
        try{
            transactionSeparator = new Separator(transactions);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    void run(){
        TransactionManager manager = transactionSeparator.load(); //loads from buffered reader
        UserInterface UI = new UserInterface(manager);
        UI.enter(); //enters what would be GUI.
    }

    public static void main(String args[]){
        if (args.length == 0) {
            System.out.println("***Incorrect usage, Use program Args to upload file <file>");
            System.exit(1);
        }
        (new transactionSorter(args[0])).run(); //loads to buffered reader

    }

}


