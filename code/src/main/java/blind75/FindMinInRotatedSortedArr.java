package blind75;

public class FindMinInRotatedSortedArr {

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("arr[mid] = " + arr[mid]);
            min = Math.min(min, arr[mid]);
            if (arr[mid] < arr[right])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return min;
    }
}
