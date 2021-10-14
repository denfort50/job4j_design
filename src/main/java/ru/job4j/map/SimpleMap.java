package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(key.hashCode()));
        boolean rsl = false;
        MapEntry<K, V> entry = new MapEntry<>(key, value);
        if (table[index] == null) {
            table[index] = entry;
            rsl = true;
            modCount++;
            count++;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity = capacity * 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> kvMapEntry : oldTable) {
            if (kvMapEntry != null) {
                put(kvMapEntry.key, kvMapEntry.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));
        V value = null;
        if (table[index] != null && table[index].key.equals(key)) {
            value = table[index].value;
        }
        return value;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        boolean rsl = false;
        if (table[index] != null && table[index].key.equals(key)) {
            table[index].value = null;
            rsl = true;
            modCount++;
            count--;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        int expectedModCount = modCount;
        return new Iterator<K>() {
            int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < table.length) {
                    if (table[point] != null) {
                        return true;
                    } else {
                        point++;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
