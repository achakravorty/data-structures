package Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap with Integer keys and String values
        Map<Integer, String> hashMap = new HashMap<>();

        // Adding entries
        hashMap.put(1, "John Doe");
        hashMap.put(2, "Jane Smith");
        hashMap.put(3, "Bob Johnson");

        // Getting values
        String name1 = hashMap.get(1);
        String name2 = hashMap.get(2);

        System.out.println("Name at key 1: " + name1);
        System.out.println("Name at key 2: " + name2);

        // Iterating through key-value pairs
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // Checking if a key exists
        boolean containsKey = hashMap.containsKey(3);
        System.out.println("Contains key 3: " + containsKey);

        // Removing an entry
        String removedValue = hashMap.remove(2);
        System.out.println("Removed value at key 2: " + removedValue);

        // Size of the HashMap
        int size = hashMap.size();
        System.out.println("Size of HashMap: " + size);
    }
}
