package algorithms.sorting;

/**
 * A selection sort, iterates through the entire array, notes the lowest element as min
 * and finds any lower element and replaces the min to direct to the new lowest index,
 * then at the end of the iteration it replaces the lowest number position with the iteration start position,
 * It starts from T(n+1) after every successful (n).
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
