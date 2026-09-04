package algorithms.sorting;

/**
 * Insertion sort with a big(O) notation of O(n^2) and one of and best case of O(n)
 * Works by sorting elements in an array by sorting it backwards, checks if the prior
 * element is greater than current element before it shifts the value a step-up, until the elements
 * are either sorted out and no prior element is greater, then places the element in that position
 * Imagine sorting a deck of cards, best analogy
 */
public class InsertionSort {

    public static void sort(int[] array) {

        for(int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
}
