package blind75;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(4);
        l2.add(6);

        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(3);
        l3.add(7);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        System.out.println(mergeKSortedLists(lists));
    }

    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        while (lists.size() > 1) {
            List<Integer> l1 = lists.getFirst();
            lists.remove(l1);

            List<Integer> l2 = lists.getFirst();
            lists.remove(l2);

            List<Integer> mergedList = mergeLists(l1, l2);
            lists.add(mergedList);
        }
        return lists.getFirst();
    }

    public static List<Integer> mergeLists(List<Integer> l1, List<Integer>  l2) {
        List<Integer> ansList = new ArrayList();
        while(l1.size() > 0 && l2.size() > 0) {
            if (l1.getFirst() < l2.getFirst()) {
                ansList.add(l1.getFirst());
                l1.remove(l1.getFirst());
            } else {
                ansList.add(l2.getFirst());
                l2.remove(l2.getFirst());
            }
        }
        if (l1.size() > 0) {
            ansList.addAll(l1);
        } else
            ansList.addAll(l2);
        return ansList;
    }
}
