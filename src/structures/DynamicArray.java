package structures;

/**
 * Dynamic array that acts exactly as an array list
 */
public class DynamicArray<E> {
    private int size; // element size
    public int capacity = 5; //default capacity is 5
    private E[] arr;

    public DynamicArray() {
        arr = (E[]) new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = (E[]) new Object[capacity];
    }

    public void append (E element) {
        if (size >= capacity) this.resize();
        arr[size] = element;
        ++size;
    }

    public E pop () {
        E element = arr[size - 1];
        arr[size - 1] = null;
        --size;
        if ((capacity - size) >= 5) this.resize();
        return element;
    }

    public E remove (int index) {
        E[] newArr = (E[]) new Object[capacity];
        E oldValue = null;
        int newArrIndex = 0;

        for(int i = 0; i < arr.length; i++) {
            if(i == index) {
                oldValue = arr[i];
                continue;
            }
            newArr[newArrIndex++] = arr[i];
        }

        // return -1 if index is not found
        //if(oldValue == null) return -1;

        this.arr = newArr;
        --size;
        if ((capacity - size) >= 5) this.resize();

        return oldValue;
    }

    public String toString() {
        StringBuilder list = new StringBuilder("[");
        for(E element : arr) {
            list.append(element).append(", ");
        }
        list.replace(list.length() - 2, list.length() - 1, "]");
        return list.toString();
    }

    private void resize() {
        int newCapacity = (size/5 + 1) * 5;
        E[] newArr = (E[]) new Object[newCapacity];

        for(int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        this.arr = newArr;
        this.capacity = newCapacity;
    }
}