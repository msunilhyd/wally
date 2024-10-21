package blind75;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int xor = nums.length;

        for (int i=0; i<nums.length; i++) {
            xor = xor ^ i ^ nums[i];
            System.out.println(xor);
        }
        return xor;
    }
}
