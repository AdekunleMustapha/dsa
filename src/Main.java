import algorithms.sorting.BubbleSort;
import structures.SinglyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();

        linkedList.appendLast(22);
        linkedList.appendLast(67);
        linkedList.appendFirst(88);
        linkedList.insert(17, 1);
        linkedList.insert(1, 1);
        linkedList.removeTail();

        System.out.println(linkedList);
    }

    public static int indexOf(long[] arr, long target) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(target ==  arr[i]) return i;
        }
        return -1;
    }
}
