package meta2;

import java.util.Arrays;
import java.util.Stack;

public class ContiguousSubArrays {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 4, 5, 5};
        System.out.println(Arrays.toString(find(arr)));
    }

    private static int[] find(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack();

        for (int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[i] += ans[stack.pop()];
            }
            ans[i]++;
            stack.push(i);
        }
        stack.clear();
        int[] temp = new int[arr.length];
        for (int i=arr.length-1; i>=0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                ans[i] += temp[idx];
                temp[i] += temp[idx];
            }
            stack.push(i);
            temp[i]++;
        }
        return ans;
    }
}
