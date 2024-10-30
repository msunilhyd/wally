package two;

import java.util.ArrayList;
import java.util.List;

public class GliderTest {

    public static void main(String[] args) {
//        System.out.println(solve(10));
//        System.out.println(solve("gt12cty65mt1"));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(2);
//        System.out.println(find(2, list));
    }



    public static int solve(int B, List<Integer> ar) {
        int totalAdditions = 0;
        for (int i = 1; i < ar.size(); i++) {
            // If the current element is not greater than the previous one
            if (ar.get(i) <= ar.get(i - 1)) {
                // Calculate how many times we need to add B
                int needed = ar.get(i - 1) - ar.get(i) + 1; // +1 to ensure ar[i] > ar[i - 1]
                int additions = (needed + B - 1) / B; // Calculate the required number of additions
                totalAdditions += additions; // Update total additions
                int val = ar.get(i) + additions * B;
                ar.set(i, val);
            }
        }
        return totalAdditions;
    }





    public static int solve(String S) {
        int largestOdd = -1;
        StringBuilder number = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    int currentNumber = Integer.parseInt(number.toString());
                    if (currentNumber % 2 != 0) {
                        largestOdd = Math.max(largestOdd, currentNumber);
                    }
                    number.setLength(0);
                }
            }
        }
        if (number.length() > 0) {
            int currentNumber = Integer.parseInt(number.toString());
            if (currentNumber % 2 != 0) {
                largestOdd = Math.max(largestOdd, currentNumber);
            }
        }
        return largestOdd; // Return the largest odd number found or -1
    }

    public static int solve(int N) {
        if (N <= 2) return 0;

        boolean[] isPrime = new boolean[N];
        for (int i = 2; i < N; i++) {
            isPrime[i] = true; // Assume all numbers are prime initially
        }

        for (int i = 2; i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false; // Mark multiples of i as non-prime
                }
            }
        }

        int count = 0;
        for (int i = 2; i < N; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
