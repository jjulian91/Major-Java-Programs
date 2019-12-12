package TransactionSort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

// QUICK SORT
public class QuickSort {
    private static int originalPivot;
    private static String comparison;
    private static int step = 1;


    /**
     * call to quicksort no pivor defined
     * @param array
     *          Array to sort
     * @param compareType
     *          Comparison to be made
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] array, String compareType) {
        comparison = compareType;
        step++;
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Call to quicksort with predefined pivot
     * @param array
     *          Array to sort
     * @param compareType
     *          Comparison to be made
     * @param pivot
     *          pivot if defined
     * @param <T>
     *          Object type
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] array, String compareType, int pivot) {
        comparison = compareType;
        originalPivot = pivot;
        step++;
        quickSort(array, 0, array.length - 1, pivot);
    }

    /**
     * recursive Call to quick sort without pre-defined pivot
     * @param a
     *         Array to sort
     * @param first
     *          First item in subarray
     * @param last
     *          last item in subarray
     * @param <T>
     *          Object Type
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] a,
                                                                   int first, int last) {
        // create the partition: Smaller | Pivot | Larger
        if(first>=last){}
        else {
            step++;
            int pivotIndex = partition(a, first, last, originalPivot);
            sortFirstMiddleLast(a, first, pivotIndex, last);
            // sort subarrays Smaller and Larger
            quickSort(a, first, pivotIndex-1);
            quickSort(a, pivotIndex+1, last);
        }
    }//end quicksort Method


    /**
     * recursive Call to quick sort with defined pivot
     * @param a
     *          Array to sort
     * @param first
     *          First item in subarray
     * @param last
     *          last item in subarray
     * @param pivot
     *          pivot point
     * @param <T>
     *          object type
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] a,
                                                                   int first, int last, int pivot) {

        step++;
        // create the partition: Smaller | Pivot | Larger
        if(first>=last){}
        else {
            int pivotIndex = partition(a, first, last, pivot);
            sortFirstMiddleLast(a, first, pivotIndex, last);
            // sort subarrays Smaller and Larger
            quickSort(a, first, pivotIndex-1);
            if(originalPivot != 0 && pivot < a.length-originalPivot)
                quickSort(a, pivotIndex+1, last, pivotIndex+originalPivot);
            else{
                quickSort(a, pivotIndex+1, last);
            }
        }
    }//end quicksort with pivot Method

    /**
     * partitions the array
     * @param a
     *          Array
     * @param first
     *          First element in subarray
     * @param last
     *          last element in subarray
     * @param mid
     *          middle of subarray
     * @param <T>
     *          Object Type
     * @return
     *          returns midpoint
     */
    private static <T extends Comparable<? super T>> int partition(T[] a,
                                                                   int first, int last, int mid) {
        Random rand = new Random();
        if(mid == -2){
            mid = (rand.nextInt(last-1)+1);
        }
        else if(mid != -1){
             mid = (first + last) / 2;
        }
        sortFirstMiddleLast(a, first, mid, last);
        swap(a, mid, last - 1);
        int pivotIndex = last - 1;
        T pivot = a[pivotIndex];
        int indexFromLeft = first + 1;
        int indexFromRight = last - 2;
        boolean done = false;
        while (!done) {
            // starting at beginning of array, leave elements that are < pivot;
            // locate first element that is >= pivot; you will find one,
            // since last element is >= pivot
            while (compare(a[indexFromLeft], pivot) < 0)
                indexFromLeft++;
            // starting at end of array, leave elements that are > pivot;
            // locate first element that is <= pivot; you will find one,
            // since first element is <= pivot
            while (compare(a[indexFromRight], pivot) > 0)
                indexFromRight--;
            assert compare(a[indexFromLeft], pivot) >= 0
                    && compare(a[indexFromRight], pivot) <= 0;
            if (indexFromLeft < indexFromRight) {
                swap(a, indexFromLeft, indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            } else{
                done = true;
                }
        } // end while
        // place pivot between Smaller and Larger subarrays
        swap(a, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;
        return pivotIndex;
    } // end partition

    /**
     * Sorts the pivot, first, and last.
     * @param a
     *          Array
     * @param first
     *          first object to be sorted
     * @param mid
     *          pivot point
     * @param last
     *          Last object to be sorted
     * @param <T>
     *          Object type
     */
    private static <T extends Comparable<? super T>> void sortFirstMiddleLast(
            T[] a, int first, int mid, int last) {
        step++;
        order(a, first, mid); // make a[first] <= a[mid]
        order(a, mid, last); // make a[mid] <= a[last]
        order(a, first, mid); // make a[first] <= a[mid]
    } // end sortFirstMiddleLast

    /**
     * orders the objects in array a.
     * @param a
     *          Array
     * @param i
     *          object 1
     * @param j
     *          object 2
     * @param <T>
     *     object Type
     */
    private static <T extends Comparable<? super T>> void order(T[] a, int i,
                                                                int j) {
        step++;
        if (compare(a[i],(a[j])) > 0)
            swap(a, i, j);
    } // end order

    /**
     * swaps positions in array
     * @param a
     *          Array
     * @param i
     *          object 1
     * @param j
     *          object 2
     */
    private static void swap(Object[] a, int i, int j) {
        step++;
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } // end swap

    /**
     *
     * @param a
     *          Object 1
     * @param b
     *          Object 2
     * @param <T>
     *          Object Type
     * @return
     *          0 < if 1 > 2
     *          0 if 1 = 2
     *          0 > if 1 < 2
     */
    private static <T extends Comparable<? super T>> int compare(Object a, Object b){
        int result = 0;
        step++;
        assert a.getClass() == b.getClass();
        try{
            Class<?> aClass = a.getClass();
            Method aMethod;
            aMethod = aClass.getMethod(comparison, Object.class);
            Object returnType = aMethod.invoke(a, b);
            result = Integer.parseInt(returnType.toString());
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            System.out.println(e);
            }
        return result;
    }

    /**
     * Returns number of steps
     * @return
     */
    public static int getStep(){return  step;}
} // end quickSort class

