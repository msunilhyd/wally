package meta;

public class LexicographicallySmallestArray {

    public static int[] findMinArray(int[] arr, int k) {
        int n = arr.length; // Length of the array

        // Iterate through the array to determine the smallest lexicographical order
        for (int i = 0; i < n && k > 0; i++) {
            // Find the minimum element within the range we can swap
            int minIndex = i; // Start with the current index as the minimum index
            for (int j = i + 1; j < Math.min(n, i + k + 1); j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // If a smaller element is found and it's not the current element
            if (minIndex != i) {
                // Calculate the number of swaps needed to bring the minimum element to the current position
                int swapsNeeded = minIndex - i;

                // Perform the necessary swaps to move the found minimum element to the current position
                for (int j = minIndex; j > i; j--) {
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

                // Decrease k by the number of swaps made
                k -= swapsNeeded; // Update remaining swaps
            }
        }

        // Return the modified array which is the lexicographically smallest sequence achievable
        return arr;
    }

    // Test the function with the provided examples
    public static void main(String[] args) {
        // Example 2
        int[] arr2 = {8, 9, 11, 2, 1};
        int k2 = 3;
        int[] result2 = findMinArray(arr2, k2);
        System.out.print("Output for arr2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected Output: [2, 8, 9, 11, 1]
        // Example 1
        int[] arr1 = {5, 3, 1};
        int k1 = 2;
        int[] result1 = findMinArray(arr1, k1);
        System.out.print("Output for arr1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected Output: [1, 5, 3]

    }
}
