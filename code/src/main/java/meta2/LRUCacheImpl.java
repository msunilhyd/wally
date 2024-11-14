package meta2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheImpl {

    int capacity;
    Map<Integer, String> map = new HashMap();
    LinkedList<Integer> linkedList = new LinkedList();

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
    }

    private String get(int key) {
        String val = map.get(key);
        linkedList.remove((Object)key);
        linkedList.addFirst(key);
        return val;
    }

    private void put(int key, String value) {
        if (map.size() >= capacity) {
            int removed = linkedList.removeLast();
            map.remove(removed);
        }
        map.put(key, value);
        linkedList.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCacheImpl lruCache = new LRUCacheImpl(2);
        lruCache.put(1, "Sunil");
        lruCache.put(2, "Prash");
        System.out.println(lruCache.map);
        lruCache.put(3, "Mom");
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.map);
        lruCache.put(4, "Hari");
        System.out.println(lruCache.map);
    }

}
