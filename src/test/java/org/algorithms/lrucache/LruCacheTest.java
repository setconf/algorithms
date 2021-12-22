package org.algorithms.lrucache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LruCacheTest {

    @Test
    void lruCacheTest() {
        LruCache<Integer, Integer> lRUCache = new LruCache<>(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        assertEquals(1, lRUCache.get(1)); // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertNull(lRUCache.get(2)); // returns null (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertNull(lRUCache.get(1)); // return null (not found)
        assertEquals(3, lRUCache.get(3)); // return 3
        assertEquals(4, lRUCache.get(4)); // return 4
    }
}
