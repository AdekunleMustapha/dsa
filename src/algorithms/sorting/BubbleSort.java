package algorithms.sorting;

/**
 * Has a big(O) notation of (n^2). Not suitable for large data
 * Works by looping through each element and swaps position if T(n+1) is greater than
 * T(n) and continues looping till it reaches the end. Then an outer loop that decreases
 * the search range by 1 because the largest T has been sorted already
 */
public class BubbleSort {

    public static void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
