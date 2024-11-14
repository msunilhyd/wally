package meta;

import java.util.Arrays;

public class BalancedSplit2 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        System.out.println(find(arr));
    }

    private static boolean find(int[] arr) {
        Arrays.sort(arr);
        int[] arrCurSum = arr.clone();
        for (int i=1; i<arr.length; i++) {
            arrCurSum[i] += arrCurSum[i-1];
        }
        for (int i=0; i<arr.length-1; i++) {
            if (arrCurSum[i] * 2 == arrCurSum[arr.length-1]) {
                if (arr[i] != arr[i+1])
                    return true;
            }
        }
        return false;
    }
}
