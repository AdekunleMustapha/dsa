package algorithms.sorting;

/**
 * Uses recursion to carry out its sorting, has a big(O) notation of (nlogn)
 * same as merge sort but in a worst case scenario it has a big(O) notation of (n^2)
 * Unlike merge sort that splits its array before performing sorting, merge sort accomplishes
 * its own by putting a pivot (key - index) at the end of the array which is used to split
 * the array into lesser than and greater than using the pivot as the judge then after puts
 * the pivot at the center point in which recursion takes place
 * So it basically doesn't sort by comparing to values but rather sorts
 * by comparing if the element is greater or lesser than the pivot, it sorts from up to down; unlike
 * merge sort which is down to up
 */
public class QuickSort {

    public static void sort(int[] array, int start, int end) {

        if(end <= start) return;

        int pivot =  partition(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for(int j = start; j < end; j++) {
            if(array[j] < pivot) {
                ++i;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        ++i;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
}
