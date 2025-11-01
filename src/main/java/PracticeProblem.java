import java.util.Arrays;

public class PracticeProblem {

    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 7, 2, 3, 4, 6, 8, 9, 2, 234, 2, 234, 234};
        String[] words = {"apple", "banana", "cherry", "date", "fig", "grape"};

        int number = 234;
        String word = "date";

        int[] intResults = compareSearch(nums, number);
        System.out.println("Integer Search Loops - Sequential: " + intResults[0] + ", Binary: " + intResults[1]);

        int[] stringResults = compareStringSearch(words, word);
        System.out.println("String Search Loops - Sequential: " + stringResults[0] + ", Binary: " + stringResults[1]);
    }

    public static int[] compareSearch(int[] array, int number) {
        int sequentialLoops = 0;
        int binaryLoops = 0;

        // Sequential search
        for (int i = 0; i < array.length; i++) {
            sequentialLoops++;
            if (array[i] == number) break;
        }
		
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);

        int low = 0, high = sortedArray.length - 1;
        while (low <= high) {
            binaryLoops++;
            int mid = (low + high) / 2;

            if (sortedArray[mid] == number) break;
            else if (sortedArray[mid] < number) low = mid + 1;
            else high = mid - 1;
        }

        return new int[]{sequentialLoops, binaryLoops};
    }

    public static int[] compareStringSearch(String[] array, String word) {
        int sequentialLoops = 0;
        int binaryLoops = 0;

        // Sequential search
        for (int i = 0; i < array.length; i++) {
            sequentialLoops++;
            if (array[i].equals(word)) break;
        }

        String[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);

        int low = 0, high = sortedArray.length - 1;
        while (low <= high) {
            binaryLoops++;
            int mid = (low + high) / 2;

            int cmp = sortedArray[mid].compareTo(word);
            if (cmp == 0) break;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return new int[]{sequentialLoops, binaryLoops};
    }
}
