package blind75;

import java.util.ArrayList;
import java.util.List;

public class FindMedianInDataStream {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        add(1);
        add(7);
        System.out.println(findMedian());
        add(3);
        add(9);
        System.out.println(findMedian());
        add(2);
        System.out.println(findMedian());
    }

    public static void add(int target) {
        int left = 0;
        int right = list.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (list.get(mid) < target)
                left++;
            else
                right--;
        }
        list.add(left, target);
    }

    public static int findMedian() {
        int mid = list.size() / 2;
        if (list.size() % 2 == 1) {
            return list.get(mid);
        } else {
            return ((list.get(mid) + list.get(mid - 1))  / 2);
        }
    }
}
