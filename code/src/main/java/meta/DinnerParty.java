package meta;

import java.util.Arrays;

public class DinnerParty {

    // Test case to demonstrate the function
    public static void main(String[] args) {
        int[] arr = {5, 10, 6, 8};
        int result = minOverallAwkwardnessMain(arr);
        System.out.println("Minimum Overall Awkwardness: " + result); // Expected output: 4
    }

    private static int minOverallAwkwardnessMain(int[] arr) {
        // Sort the array in increasing order such that the differences in adjacent heights are minmized
        Arrays.sort(arr);

        // diff holds the maximum awkwardness encountered
        int diff = arr[1] - arr[0];

        // Loop over the elements starting from index 2, considering pairs at even indices
        // This loop calculates the maximum difference between every alternate element (arr[i] - arr[i-2])
        for (int i=2; i<arr.length; i=i+2) {
            diff = Math.max(diff, arr[i] - arr[i-2]);
        }

        // Loop over elements starting from index 3, considering pairs at odd indices
        // This loop calculates the maximum difference between every alternate element (arr[i] - arr[i-2])
        for (int i=3; i<arr.length; i+=2) {
            diff = Math.max(diff, arr[i] - arr[i-2]);
        }

        // finally, calculate the maximum difference between the last 2 elements in the sorted array
        return Math.max(diff, arr[arr.length - 1] - arr[arr.length - 2]);
    }
}
