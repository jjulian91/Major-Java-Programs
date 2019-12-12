package TransactionSort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MergeSort {
    // MERGE SORT
    private static String comparison;
    private  static int step = 0;

    /**
     * intial call for mergeSort
     * @param a
     *          Array to be sorted
     * @param compareType
     *          comparison to be used
     * @param <T>
     *          Type of object used for generics
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] a, String compareType) {
        step++;
        comparison = compareType;
        mergeSort(a, 0, a.length-1);
    } // end mergeSort

    /**
     * second call from entry point
     * @param a
     *          Array to be sorted
     * @param first
     *          First element of array to be sorted
     * @param last
     *          Last element of array to be sorted
     * @param <T>
     *          Type of objects
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] a,
                                                                   int first, int last) {
        step++;
        T[] tempArray = (T[]) new Comparable<?>[a.length];
        mergeSort(a, tempArray, first, last);
    } // end mergeSort

    /**
     * Successive call to MergeSort, broken into temp array
     * @param a
     *          Array to be sorted
     * @param tempArray
     *          Temp array for division
     * @param first
     *          First item to be sorted in array
     * @param last
     *          Last item to be sorted in array
     * @param <T>
     *          Object type for generics
     */
    private static <T extends Comparable<? super T>> void mergeSort(T[] a,
                                                                    T[] tempArray, int first, int last) {
        step++;
        if (first < last) { // sort each half
            int mid = (first + last) / 2;// index of midpoint
            mergeSort(a, first, mid); // sort left half array[first..mid]
            mergeSort(a, mid + 1, last); // sort right half array[mid+1..last]

            if (compare(a[mid],a[mid + 1]) > 0) // Question 2, Chapter 12
                merge(a, tempArray, first, mid, last); // merge the two halves
            // else skip merge step
        } // end if
    } // end mergeSort

    /**
     * Successive call to divide
     * @param a
     *          Original array
     * @param tempArray
     *          Array to be sorted
     * @param first
     *          First item to be sorted
     * @param mid
     *          Middle point
     * @param last
     *          Last item to be sorted
     * @param <T>
     *          object type
     */
    private static <T extends Comparable<? super T>> void merge(T[] a,
                                                                T[] tempArray, int first, int mid, int last) {
        step++;
        // Two adjacent subarrays are a[beginHalf1..endHalf1] and
        // a[beginHalf2..endHalf2].
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;

        // while both subarrays are not empty, copy the
        // smaller item into the temporary array
        int index = beginHalf1; // next available location in
        // tempArray
        for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++) {
            step++;
            if (compare(a[beginHalf1],a[beginHalf2]) < 0) {
                tempArray[index] = a[beginHalf1];
                beginHalf1++;

            } else {
                tempArray[index] = a[beginHalf2];
                beginHalf2++;

            } // end if
        } // end for

        // finish off the nonempty subarray

        // finish off the first subarray, if necessary
        for (; beginHalf1 <= endHalf1; beginHalf1++, index++){
            // Invariant: tempArray[beginHalf1..index-1] is in order
            tempArray[index] = a[beginHalf1];
            step++;
        }

        // finish off the second subarray, if necessary
        for (; beginHalf2 <= endHalf2; beginHalf2++, index++){
            // Invariant: tempa[beginHalf1..index-1] is in order
            tempArray[index] = a[beginHalf2];
            step++;
        }

        // copy the result back into the original array
        for (index = first; index <= last; index++){
            step++;
            a[index] = tempArray[index];
        }

    } // end merge

    /**
     * Object comparison
     * @param a
     *          Object 1
     * @param b
     *          Object 2
     * @param <T>
     *          Object type
     * @return
     *          0 < if 1 > 2
     *          0 if 1 = 2
     *          0 > if 1 > 2
     */
    private static <T extends Comparable<? super T>> int compare(Object a, Object b){
        step++;
        int result = 0;
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
     * retrieves number of steps
     * @return
     */
    public static int getStep(){return step;}
}
