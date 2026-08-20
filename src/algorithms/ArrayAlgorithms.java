package algorithms;

public class ArrayAlgorithms {
    public static double largestNumber (double... numbers) {
        int arrayLength = numbers.length;
        int index = 0;
        int nextIndex = index + 1;

        while (nextIndex < arrayLength) {
            if ( numbers[index] < numbers[nextIndex]) {
              index = nextIndex;
            }
            nextIndex++;
        }

        return numbers[index];
    }
}
