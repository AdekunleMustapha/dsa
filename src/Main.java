import algorithms.sorting.BubbleSort;
import algorithms.sorting.SelectionSort;
import structures.SinglyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        System.out.println(factorial(5));
    }

    public static int indexOf(long[] arr, long target) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(target ==  arr[i]) return i;
        }
        return -1;
    }

    /**
     * Practicing recursion, good due to simpler code but bad because it eats memory
     */
    public static int factorial(int number){

        if(number == 1) return 1;

        return number * factorial(number - 1);
    }
}
