package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) throws IOException {
        V result = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (result == null) {
            V value = load(key);
            put(key, value);
            result = cache.get(key).get();
        }
        return result;
    }

    protected abstract V load(K key);
}
