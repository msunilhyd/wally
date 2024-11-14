package meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueRemovals {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5};
        System.out.println(Arrays.toString(findPositions(arr, 5)));
    }

    private static int[] findPositions(int[] arr, int x) {
        LinkedList<Element> queue = new LinkedList<>();
        int[] result = new int[x];
        for (int i=0; i<arr.length; i++) {
           queue.add(new Element(arr[i], i+1));
        }
        int resultIndex = 0;
        while (!queue.isEmpty()) {
            if (resultIndex > arr.length-1)
                break;
            List<Element> tempList = new ArrayList();
            int maxElement = Integer.MIN_VALUE;
            int maxIndex = -1;
            int count = x;

            while (count > 0) {
                count--;
                if (queue.isEmpty()) {
                    break;
                }
                Element element = queue.removeFirst();
                if (element.value > maxElement) {
                    maxElement = element.value;
                    maxIndex = element.index;
                }
                tempList.add(element);
            }
            for (Element temp : tempList) {
                if (temp.value == maxElement && temp.index == maxIndex) {
                    result[resultIndex++] = temp.index;
                    continue;
                }
                if (temp.value != 0)
                    temp.value -= 1;
                queue.addLast(temp);
            }
            System.out.println(resultIndex);
        }
        return result;
    }
}

class Element {
    int value;
    int index;
    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
