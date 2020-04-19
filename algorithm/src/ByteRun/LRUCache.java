package ByteRun;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {
    private Integer cacheSize;
    private Map<Integer, String> map = new LinkedHashMap<>(2, 0.75F, true);

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.pushNum(1, "1");
        lruCache.pushNum(2, "2");
        System.out.println(lruCache.getNum(1));
        lruCache.pushNum(3, "3");
        System.out.println(lruCache.getNum(2));
        lruCache.pushNum(4, "4");
        System.out.println(lruCache.getNum(1));
        System.out.println(lruCache.getNum(3));
        System.out.println(lruCache.getNum(4));
    }

    private void pushNum(int key, String value) {
        // 数量大于2时要先将最不经常使用的那个元素删除，再添加新的元素
        if (map.size() >= 2) {
            Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }

    private String getNum(int key) {
        return map.get(key);
    }
}
