package TransactionSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Separator extends Object{
    private BufferedReader transactionCSV;

    /**
     * constructor
     * @param fileToParse
     *          String arg passed
     * @throws IOException
     */
    public Separator(String fileToParse)throws IOException {
        this.transactionCSV = new BufferedReader(new FileReader(fileToParse));
    }


    /**
     * Loads the transactions to the Arraylist -> arraylist generates The Transaction manager
     * @return
     *      TransactionManager -> list of all transactions
     */
    public TransactionManager load(){
        ArrayList<Transaction> transactionsArray = new ArrayList<>();
        String lineRead;
        String tokenRead;

        boolean header = true;
        try{
            while((lineRead = transactionCSV.readLine())!=null) {
                StringTokenizer tokenizer = new StringTokenizer(lineRead, "\t");
                boolean status = false, merchant = false, date = false;
                String transactionDate = "blank";
                String merchantName = "blank";
                double transactionAmnt = 0;

                if(!header){
                    while(tokenizer.hasMoreTokens()){
                        tokenRead = tokenizer.nextToken();
                        if(!status && tokenizer.hasMoreTokens()){
                            status = true;
                            tokenRead = tokenizer.nextToken();
                        }
                        if(!date){
                            transactionDate = tokenRead;
                            date = true;
                        }
                        else if(!merchant){
                            merchantName = tokenRead;
                            merchant = true;
                        }
                        else{
                                tokenRead = tokenRead.replace('$', ' ');
                            while(tokenRead.contains(",")){
                                StringBuilder sb = new StringBuilder(tokenRead);
                                int substringValue = tokenRead.indexOf(',');
                                sb.deleteCharAt(substringValue);
                                tokenRead = sb.toString();
                            }
                            if(tokenRead.contains("-")){
                                tokenRead = tokenRead.replace('-', ' ');
                                transactionAmnt = -Double.parseDouble(tokenRead);
                            }
                            else{
                                transactionAmnt = Double.parseDouble(tokenRead);
                            }
                        }
                    }
                }
                if(!transactionDate.equals("blank")){
                    Transaction parsedTransaction = new Transaction(transactionDate, merchantName, transactionAmnt);
                    transactionsArray.add(parsedTransaction);
                }
                header = false;
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        return new TransactionManager(transactionsArray);

    }
}
