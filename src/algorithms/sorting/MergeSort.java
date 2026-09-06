package algorithms.sorting;

/**
 * Has a big(O) notation of O(n log n) and uses recursion to get the work done,
 * but it takes more memory. It basically works by divide and conquer; by performing
 * recursion of splitting till the last element makes a single array, it then makes the
 * right array do the same before merging takes place using a helper function that doesn't
 * use a recursion but rather comparison to determine smaller elements and re-ordering of array.
 * Keep in mind merge sort has a memory-to-data complexity of O(n)
 */
public class MergeSort {

    //Recursive process
    public static void sort(int[] array) {

        if(array.length <= 1) return; // base case

        int middle = array.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];

        //splits array into two sub arrays
        for(int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }

        for(int i = 0; i < array.length - middle; i++) {
            rightArray[i] = array[i + middle];
        }

        // left array is dived fully first
        sort(leftArray);
        // right array follows next
        sort(rightArray);
        // called only after when left array and right array has been divided fully
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0; //main index
        int l = 0; // left index
        int r = 0; // right index

        // while loop is favored to for loop due to it not being an iteration
        // but more of a condition and doesn't necessarily have to reach the end of the index i,
        // as to save space for uneven sub arrays
        while(l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                ++l;
            } else {
                array[i] = rightArray[r];
                ++r;
            }
            ++i;
        }

        while(l < leftSize) {
            array[i] =leftArray[l];
            ++l;
            ++i;
        }

        while(r < rightSize) {
            array[i] = rightArray[r];
            ++r;
            ++i;
        }
    }
}
