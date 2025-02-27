package org.dsa.hashTable;

class HashTable {
    // Pair class to store key-value pairs
    class Pair {
        private int key;
        private String value;

        // Constructor for creating a Pair
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
    }

    private static final int SLOT = 10;  // Set the number of slots (buckets)
    private Pair[] table;

    public HashTable() {
        table = new Pair[SLOT];
    }

    // Hash function to calculate the index
    public int hash(int key) {
        return key % SLOT;
    }

    // Insert a key-value pair into the hash table
    public void put(int key, String value) {
        int index = hash(key);

        // Check if there's already a pair at the index
        if (table[index] != null) {
            // Collision handling: If the key exists, update the value
            if (table[index].getKey() == key) {
                table[index].setValue(value);
            } else {
                // Handle collision with a simple overwrite or chain (expand later)
                System.out.println("Collision detected at index " + index);
                table[index] = new Pair(key, value);  // Overwrite (improve later with chaining)
            }
        } else {
            table[index] = new Pair(key, value);
        }
    }

    // Retrieve the value for a given key
    public String get(int key) {
        int index = hash(key);
        if (table[index] != null && table[index].getKey() == key) {
            return table[index].getValue();
        }
        return null;  // If the key does not exist
    }

    // Optional: To display the entire hash table for debugging
    public void display() {
        for (int i = 0; i < SLOT; i++) {
            if (table[i] != null) {
                System.out.println("Index " + i + ": Key = " + table[i].getKey() + ", Value = " + table[i].getValue());
            }
        }
    }
}

public class HashTableMain {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Insert key-value pairs
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(11, "Eleven");  // This will collide with key 1 because of hash(11) % 10 == hash(1)

        // Retrieve and print values
        System.out.println("Key 1: " + hashTable.get(1));  // Output: One
        System.out.println("Key 2: " + hashTable.get(2));  // Output: Two
        System.out.println("Key 11: " + hashTable.get(11));  // Output: Eleven

        // Display the entire hash table
        hashTable.display();
    }
}
