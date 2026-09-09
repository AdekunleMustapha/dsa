import algorithms.sorting.*;
import structures.DoublyLinkedList;
import structures.SinglyLinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int[] array = { 9, 2, 5, 4, 6, 7, 1, 0, 3, 5};

        QuickSort.sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static int indexOf(long[] arr, long target) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(target ==  arr[i]) return i;
        }
        return -1;
    }

    /**
     * Practicing recursion, good due to simpler code but bad because it eats memory
     * Useful for learning merge sort and quick sort
     */
    public static int factorial(int number){

        if(number == 1) return 1;

        return number * factorial(number - 1);
    }
}
