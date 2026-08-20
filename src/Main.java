import algorithms.DynamicArray;

public class Main {

    public static void main(String[] args) {
        DynamicArray<Number> dynamicArray = new DynamicArray<>();

        dynamicArray.append(24);
        dynamicArray.append(25);
        dynamicArray.append(26);
        dynamicArray.append(27);
        dynamicArray.append(28);
        dynamicArray.append(29);

        System.out.println("Dynamic Array list: " + dynamicArray);
        System.out.println("Capacity: " + dynamicArray.capacity);
    }

    public static int indexOf(long[] arr, long target) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(target ==  arr[i]) return i;
        }
        return -1;
    }
}
