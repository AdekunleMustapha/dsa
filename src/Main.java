import algorithms.sorting.BubbleSort;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();

        int[] array = {6, 3, 5, 8, 1 , 9, 2, 7, 4, 0};

        BubbleSort.sort(array);

        System.out.println(Arrays.toString(array));
    }

    public static int indexOf(long[] arr, long target) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(target ==  arr[i]) return i;
        }
        return -1;
    }
}
