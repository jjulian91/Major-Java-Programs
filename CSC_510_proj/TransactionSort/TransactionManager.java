package TransactionSort;

import java.util.ArrayList;

public class TransactionManager {

    ArrayList<Transaction> transactionsArray;


    /**
     * constructor
     * @param transactionList
     *              ArrayList of transactions
     */
    TransactionManager(ArrayList<Transaction> transactionList){
            this.transactionsArray = transactionList;
        }

    /**
     * accessor for ArrayList
     * @return
     */
    public ArrayList<Transaction> getTransactions(){
            return transactionsArray;
        }

    /**
     * returns number of transactions
     * @return
     */
    public int size(){
            return transactionsArray.size();
        }

    /**
     * Takes args from UI to determine which algorithm to use
     * @param value
     *              Value correlates to sort type
     * @param pivot
     *              pivot used for quicksort
     */
    public void sortArray(int value, int pivot){
            Transaction[] transactionArray =
                    getTransactions().toArray(new Transaction[size()]);
            boolean quickSort = false, mergeSort = false;
            String comparison;
            if(value > 20){
                quickSort = true;
                mergeSort = true;
                value-=20;
            }
            else if (value > 10){
                quickSort = true;
                value -= 10;
            }
            else{mergeSort = true;}
            if(value == 1){
                comparison = "compareDate";
            }
            else if(value == 2){
                comparison = "compareMerchant";
            }
            else{
                comparison = "compareTo";
            }
            if(mergeSort && quickSort){
                callQuickSort(transactionArray, comparison, pivot);

                System.out.println("\nPlease wait running Merge Sort:\n");
                callMergeSort(getTransactions().toArray(new Transaction[size()]), comparison);
            }
            else if(quickSort)
            {
                callQuickSort(transactionArray, comparison, pivot);
            }
            else{
                callMergeSort(transactionArray, comparison);
            }

/*      UNCOMMENT TO SEE ARRAY PRINTOUT
        for (Transaction t:transactionArray) {
            System.out.println(t.toString());
        }*/

        }


    /**
     * calls quick sort
     * @param a
     *          Array
     * @param comparison
     *          Comparison used
     * @param pivot
     *          pivot used // default -1
     * @param <T>
     *          Type of object
     */
        private static <T extends Comparable<? super T>> void callQuickSort(T[] a, String comparison, int pivot){
            long startTime = System.currentTimeMillis();
            if(pivot == -1){ //default for quicksort
                QuickSort.quickSort(a, comparison);
            }
            else{QuickSort.quickSort(a, comparison, pivot);}
            long endTime = System.currentTimeMillis();
            System.out.println("QuickSort time elapsed in milliseconds : "+(endTime-startTime)+"\tSteps taken "
                    +QuickSort.getStep()+"\n\n");
        }

    /**
     *
     * @param a
     *          Array to sort
     * @param comparison
     *          Comparison used
     * @param <T>
     *          Object type
     */
        private static <T extends Comparable<? super T>> void callMergeSort(T[] a, String comparison){
            long startTime = System.currentTimeMillis();
            MergeSort.mergeSort(a, comparison);
            long endTime = System.currentTimeMillis();

            System.out.println("Time elapsed in milliseconds : "+(endTime - startTime)+"\tSteps Taken "+
                    MergeSort.getStep()+"\n\n");
        }
}

