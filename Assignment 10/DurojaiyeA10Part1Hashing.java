// Name: Emmanuel Durojaiye
// Class: CS 3305 / W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 10-Part-1-Hashing

import java.util.HashSet;
import java.util.Set;

public class DurojaiyeA10Part1Hashing<K, V> implements MyMap<K, V> {
    // Initial capacity of the hash table
    private static final int iniCap= 4;
    // Load factor threshold for resizing the hash table
    private static final float threshold = 0.5f;

    // Array to store entries in the hash table
    private Entry<K, V>[] table;
    // Number of key-value pairs in the hash table
    private int size;

    // Constructor to initialise the hash table
    public DurojaiyeA10Part1Hashing() {
        table = new MyMap.Entry[iniCap];
        size = 0;
    }

    // Hash function to compute index based on key
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public void clear() {
        // Clear all entries in the hash table
        table = new MyMap.Entry[iniCap];
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        // Calculate initial index
        int index = hash(key);
        // Store the initial index to detect loop
        int initialIndex = index;

        // Linear probing to find the key
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                // Key found
                return true;
            }
            // Move to the next index
            index = (index + 1) % table.length;
            // Stop if looped back to start
            if (index == initialIndex) break;
        }
        // Key not found
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        // Check if any entry in the table has the given value
        for (MyMap.Entry<K, V> entry : table) {
            if (entry != null && entry.getValue().equals(value)) {
                // Value found
                return true;
            }
        }
        // Value not found
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        // Add each non-null entry to the set
        for (MyMap.Entry<K, V> entry : table) {
            if (entry != null) {
                entrySet.add(entry);
            }
        }
        // Return set of entries
        return entrySet;
    }

    @Override
    public V get(K key) {
        // Calculate initial index
        int index = hash(key);
        // Store the initial index to detect loop
        int initialIndex = index;

        // Linear probing to find the key
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                // Return value if key is found
                return table[index].getValue();
            }
            // Move to the next index
            index = (index + 1) % table.length;
            // Stop if looped back to start
            if (index == initialIndex) break;
        }
        // Key not found
        return null;
    }

    @Override
    public boolean isEmpty() {
        // Return true if size is 0
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        // Add each non-null key to the set
        for (MyMap.Entry<K, V> entry : table) {
            if (entry != null) {
                keySet.add(entry.getKey());
            }
        }
        // Return set of keys
        return keySet;
    }

    @Override
    public V put(K key, V value) {
        // Resize if load factor exceeds threshold
        if (size >= table.length * threshold) {
            resize();
        }

        // Calculate initial index
        int index = hash(key);
        // Store the initial index to detect loop
        int initialIndex = index;

        // Linear probing to find a slot for the key
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                // Key already exists, update value
                V oldValue = table[index].getValue();
                table[index].value = value;
                // Return old value
                return oldValue;
            }
            // Move to the next index
            index = (index + 1) % table.length;
            // Stop if looped back to start
            if (index == initialIndex) break;
        }

        // Add new entry at the found index
        table[index] = new MyMap.Entry<>(key, value);
        // Increasing size
        size++;
        // No previous value, return null
        return null;
    }

    @Override
    public void remove(K key) {
        // Calculate initial index
        int index = hash(key);
        // Store the initial index to detect loop
        int initialIndex = index;

        // Linear probing to find the key to remove
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                // Key found, remove entry
                table[index] = null;
                // Decreasing size
                size--;
                // Rehash subsequent elements in the cluster
                rehashFrom(index);
                return;
            }
            // Move to the next index
            index = (index + 1) % table.length;
            // Stop if looped back to start
            if (index == initialIndex) break;
        }
    }

    // Rehash elements after a removal to fill gaps in the cluster
    private void rehashFrom(int emptyIndex) {
        int index = (emptyIndex + 1) % table.length;

        // Continue rehashing until a null slot is found
        while (table[index] != null) {
            MyMap.Entry<K, V> entry = table[index];
            // Remove current entry
            table[index] = null;
            // Decreasing size temporarily
            size--;
            // Reinsert entry
            put(entry.getKey(), entry.getValue());
            index = (index + 1) % table.length;
        }
    }

    @Override
    public int size() {
        // Return current size of the map
        return size;
    }

    @Override
    public Set<V> values() {
        Set<V> values = new HashSet<>();
        // Add each non-null value to the set
        for (MyMap.Entry<K, V> entry : table) {
            if (entry != null) {
                values.add(entry.getValue());
            }
        }
        // Return set of values
        return values;
    }

    // Resize the hash table when load factor exceeds threshold
    private void resize() {
        // Store current table
        MyMap.Entry<K, V>[] oldTable = table;
        // Double the size
        table = new MyMap.Entry[oldTable.length * 2];
        // Reset size
        size = 0;

        // Rehash all non-null entries in the old table
        for (MyMap.Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }
}