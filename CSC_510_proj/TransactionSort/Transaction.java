package TransactionSort;

public class Transaction  implements  Comparable{
    private String merchant;
    private int transactionYear;
    private int transactionMonth;
    private int transactionDay;
    private double credit = 0;
    public Transaction(){
        merchant = "Blank";
        transactionYear = 0;
        transactionDay = 0;
        transactionMonth = 0;
    }

    /**
     * constructor
     * @param transactionDate
     *          String of date
     * @param merchant
     *          String merchant
     * @param credit
     *          Double Credit/purchase amount
     */
    public Transaction(String transactionDate, String merchant, double credit){
        this.merchant = merchant;
        parseDate(transactionDate);
        this.credit = credit;
    }

    private void parseDate(String transactionDate){
        String[] date = transactionDate.split("/");
        this.transactionYear = Integer.parseInt(date[2]);
        this.transactionDay = Integer.parseInt(date[1]);
        this.transactionMonth = Integer.parseInt(date[0]);
    }

    public double getCredit() {
        return credit;
    }


    @Override
    public String toString() {
        return merchant + "\t\t\t" +
               transactionYear+"-"+transactionMonth +"-"+ transactionDay+ "\t\t\t" +
               + credit;
    }

    /**
     * default comparison - > compares object1 credit to object 2 credit
     * @param o
     *          Object to compare
     * @return
     */
    @Override
    public int compareTo(Object o) {
        assert o instanceof Transaction;
        Transaction compare = (Transaction) o;
        return Double.compare(credit, compare.getCredit());
    }

    /**
     * compares object1 merchant to object 2 merchant
     * @param o
     *          object to compare
     * @return
     */
    public int compareMerchant (Object o){
        assert o instanceof Transaction;
        Transaction compare = (Transaction) o;
        return(merchant.compareTo(((Transaction) o).merchant));
    }

    /**
     * compares object1 Date to object 2 Date
     * @param o
     *          object to compare.
     * @return
     */
    public int compareDate (Object o){
        assert o instanceof Transaction;
        Transaction compare = (Transaction) o;
        if(transactionYear == compare.transactionYear){
            if(transactionMonth == compare.transactionMonth)
                return Integer.compare(transactionDay, compare.transactionDay);
            else{return Integer.compare(transactionMonth, compare.transactionMonth);}
        }
        else return Integer.compare(transactionYear, compare.transactionYear);
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
