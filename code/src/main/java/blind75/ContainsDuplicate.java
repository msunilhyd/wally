package blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 4};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(Integer [] nums) {
        Set<Integer> numberSet = new HashSet();
        numberSet.addAll(Arrays.asList(nums));
        if (numberSet.size() == nums.length)
            return false;
        return true;
    }
}
