package meta;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingTriangles {

    public static void main(String[] args) {
        int[][] arrs = {
                {2, 2, 3},
                {2, 3, 2},
                {1, 2 ,3}
        };
        System.out.println(find(arrs));
    }

    private static int find(int[][] arrs) {
        Set<List<Integer>> set = new HashSet<>();
        for(int[] arr: arrs){
            Arrays.sort(arr);
            List<Integer> list = Arrays.stream(arr)
                            .boxed()
                                    .collect(Collectors.toList());
            set.add(list);
        }
        System.out.println(set);
        return set.size();
    }
}
