public class HashMapTest {
    public static void main(String[] args){

        MyMap<String, Integer> map = new DurojaiyeA10Part1Hashing<>();
        // Insert key-value pairs into the map
        map.put("Jeffrey", 30);
        map.put("William", 21);
        map.put("Huey", 11);
        map.put("Riley", 11);

        // Print the contents of the map
        System.out.println("Entries in the map:");
        for (MyMap.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }

        // Test retrieving values for specific keys
        System.out.println("\nRetrieving values:");
        System.out.println("Value for 'Jeffrey': " + map.get("Jeffrey")); // Should be 70
        System.out.println("Value for 'William': " + map.get("William")); // Should be 21
        System.out.println("Value for 'Huey': " + map.get("Huey"));       // Should be 11
        System.out.println("Value for 'Riley': " + map.get("Riley"));     // Should be 11

        // Check if specific keys exist in the map
        System.out.println("\nKey existence check:");
        System.out.println("Is 'Jeffrey' on the map: " + map.containsKey("Jeffrey")); // true
        System.out.println("Is 'Carlton' on the map: " + map.containsKey("Carlton")); // false
        System.out.println("Is 'Milton' on the map: " + map.containsKey("Huey")); // true

        // Print size of the map
        System.out.println("\nSize of map: " + map.size());

        // Print all keys and values separately
        System.out.println("\nAll keys in the map: " + map.keySet());
        System.out.println("All values in the map: " + map.values());

        // Remove a key and check the size again
        System.out.println("\nRemoving key 'William'.");
        map.remove("William");

        System.out.println("Size of map after removal: " + map.size());

        // Final map entries after removal
        System.out.println("\nFinal entries in the map:");
        for (MyMap.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
