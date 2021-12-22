package org.algorithms.lrucache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * We are given total possible page numbers that can be referred. We are also given cache (or memory)
 * size (Number of page frames that cache can hold at a time). The LRU caching scheme is to remove
 * the least recently used frame when the cache is full and a new page is referenced which is not there in cache.
 *
 * @see <a href="https://www.interviewcake.com/concept/java/lru-cache">LRU Cache</a>
 * */
public class LruCache<K, V> {
    private final int capacity;
    private final Deque<K> lastToLeastKeys;
    private final Map<K, V> cache;

    public LruCache(int capacity) {
        this.capacity = capacity;
        lastToLeastKeys = new LinkedList<>();
        cache = new HashMap<>(capacity);
    }

    public void put(K key, V value) {
        if (cache.size() == capacity) {
            K lruKey = lastToLeastKeys.pollLast();
            cache.remove(lruKey);
        }
        cache.put(key, value);
        processLastKey(key);
    }

    public V get(K key) {
        V value = cache.get(key);
        if (cache.containsKey(key)) processLastKey(key);
        return value;
    }

    private void processLastKey(K key) {
        lastToLeastKeys.remove(key);
        lastToLeastKeys.addFirst(key);
    }
}
