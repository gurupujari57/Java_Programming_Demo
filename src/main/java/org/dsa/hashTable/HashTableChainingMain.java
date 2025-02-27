package org.dsa.hashTable;

import java.util.LinkedList;

class HashTableChain {
    // Inner Pair class to store key-value pairs
    class Pair {
        private int key;
        private String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    private static final int SLOT = 10;  // Number of slots (buckets)
    private LinkedList<Pair>[] table;  // Array of LinkedLists to store pairs

    public HashTableChain() {
        table = new LinkedList[SLOT];
        for (int i = 0; i < SLOT; i++) {
            table[i] = new LinkedList<>();  // Initialize each slot as a LinkedList
        }
    }

    // Hash function to compute index for a key
    public int hash(int key) {
        return key % SLOT;
    }

    // Insert key-value pair into the hash table
    public void put(int key, String value) {
        int index = hash(key);
        LinkedList<Pair> bucket = table[index];

        // Check if the key already exists in the bucket (LinkedList)
        for (Pair pair : bucket) {
            if (pair.getKey() == key) {
                pair.setValue(value);  // If the key exists, update the value
                return;
            }
        }

        // If the key doesn't exist, add a new pair to the bucket
        bucket.add(new Pair(key, value));
    }

    // Retrieve value for a given key
    public String get(int key) {
        int index = hash(key);
        LinkedList<Pair> bucket = table[index];

        // Traverse the bucket (LinkedList) to find the key
        for (Pair pair : bucket) {
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }

        return null;  // If the key is not found
    }

    // Delete a key-value pair from the hash table
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Pair> bucket = table[index];

        // Find the pair with the given key and remove it
        for (Pair pair : bucket) {
            if (pair.getKey() == key) {
                bucket.remove(pair);
                return;
            }
        }
    }

    // Optional: Display the entire hash table for debugging
    public void display() {
        for (int i = 0; i < SLOT; i++) {
            if (!table[i].isEmpty()) {
                System.out.println("Index " + i + ": " + table[i]);
            }
        }
    }
}

public class HashTableChainingMain {
    public static void main(String[] args) {
        // Create a new hash table
        HashTableChain hashTable = new HashTableChain();

        // Insert key-value pairs into the hash table
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(11, "Eleven");  // This will collide with key 1 because hash(11) % 10 == hash(1)

        // Retrieve and print values
        System.out.println("Key 1: " + hashTable.get(1));  // Output: One
        System.out.println("Key 2: " + hashTable.get(2));  // Output: Two
        System.out.println("Key 11: " + hashTable.get(11));  // Output: Eleven

        // Display the entire hash table
        System.out.println("\nDisplaying the entire hash table:");
        hashTable.display();

        // Remove a key-value pair
        hashTable.remove(2);

        // Display the hash table again after removal
        System.out.println("\nHash table after removing key 2:");
        hashTable.display();
    }
}
