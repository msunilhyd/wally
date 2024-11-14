package meta;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheImpl {

//    HashMap to store the cache data
//    key as the integer, value as the string
    Map<Integer, String> data = new HashMap<>();
//    LinkedList to store the order of the cache access
    LinkedList<Integer> order = new LinkedList<>();
//    size of the cache
    int capacity;

    LRUCacheImpl(int capacity) {
        this.capacity = capacity;
    }

    void put(int key, String val) {
        if (order.size() >= capacity) {
            int removed = order.removeLast();
            data.remove(removed);
        }
        order.addFirst(key);
        data.put(key, val);
    }


    String get(int key) {
        if (data.get(key) == null)
            return "-";
        order.remove((Object) key);
        order.addFirst(key);
        return data.get(key);
    }

    private void display() {
        for (Map.Entry<Integer, String> e : data.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }

    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four"); // putting new cache when full. 1 will be removed
        cache.get(3); // accessing 3, it will be moved to top
        cache.get(2);// accessing 2, it will be moved to top
        cache.put(1, "one"); // putting new cache when full. 4 will be removed
        cache.get(3);// accessing 3, it will be moved to top
        cache.get(1);// accessing 1, it will be moved to top
        cache.display(); // 1 should be on top
    }
}
