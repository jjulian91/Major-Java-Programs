package TransactionSort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    TransactionManager transactionList;
    public UserInterface(TransactionManager transactionList){
        this.transactionList = transactionList;
    }

    /**
     * entry point for user interface
     */
    public void enter(){
        Scanner userInput = new Scanner(System.in);

        //loop to run program until user closes
        boolean running = true;
        do {
            int sortingVal = 0;
            System.out.println("enter -99 to stop at any time");
            int input = 0;
            boolean incorrect = true;
            //loop for determining comparison
            do {
                try {
                    System.out.println("What would you like to sort by?");
                    System.out.println("Enter 1 for Transaction Date \nEnter 2 for Merchant \nEnter 3 for Amount");
                    input = Integer.parseInt(userInput.next());
                    if (input == -99) {
                        running = false;
                        break;
                    }
                    if (input < 4 && input > 0)
                        incorrect = false;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Please only enter an integer value");
                }
            }
            //UI loop for determining what algorithm to use
            while (incorrect && running);
            incorrect = true;
            sortingVal = input;
            while (incorrect && running) {
                try {
                    System.out.println("What algorithm would you like to use?");
                    System.out.println("Enter 10 for Quicksort\nEnter 0 for MergeSort\nEnter 20 for both");
                    input = Integer.parseInt(userInput.next());
                    if (input == -99) {
                        running = false;
                        sortingVal = -99;
                        break;
                    }
                    if (input == 10 || input == 0 || input == 20){
                        sortingVal += input;
                        incorrect = false;
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Please only enter an integer value");
                }
            }
            int pivot = -1;
            if(sortingVal > 10) {
                incorrect = true;
                //pivot to select IF using quicksort
                while (incorrect && running) {
                    try {
                        System.out.println("Which pivot would you like to use?");
                        System.out.println("Enter -1 for default\nEnter -2 for random" +
                                "\nEnter value between 1 and " + (transactionList.size() - 1));
                        pivot = Integer.parseInt(userInput.next());
                        if (pivot == -99) {
                            running = false;
                            sortingVal = -99;
                            break;
                        }
                        if ((pivot > 0 && pivot < transactionList.size()) || pivot == -1 || pivot == -2)
                            incorrect = false;
                    } catch (InputMismatchException | NumberFormatException e) {
                        System.out.println("Please only enter an integer value");
                    }
                }
            }
            if(sortingVal != -99)
                transactionList.sortArray(sortingVal, pivot);
        } while(running);
    }
}
