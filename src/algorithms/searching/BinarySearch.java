package algorithms.searching;

/**
 * Has a big(O) notation of log(n), both in best and worst case scenarios
 * Useful in large data searches and can only work with sorted data
 */
public class BinarySearch {

    /**
     * Returns the index position of target in an array
     */
    public static int search(long target, long[] arr) {

        int head = arr.length - 1;
        int tail = 0;

        while(tail <= head) {
            int midIndex = tail + (head - tail) / 2;

            if(arr[midIndex] == target) {
                return midIndex;
            }
            if( target > arr[midIndex]) {
                tail = midIndex + 1;
            } else {
                head = midIndex - 1;
            }
        }

        // return -1 if target isn't found
        return -1;
    }
}
