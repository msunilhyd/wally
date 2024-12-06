package blind75_2;

public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 9, 4};
        System.out.println(find(nums));
    }

    private static int find(int[] nums) {
        int min = 0;
        int maxProfit = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] < nums[min])
                min = i;
            maxProfit = Math.max(maxProfit, nums[i] - nums[min]);
        }
        return maxProfit;
    }
}
