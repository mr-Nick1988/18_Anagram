package telran.words.utils;

import java.util.HashMap;
import java.util.Set;

public class Anagram {
     //O(n)
    public static boolean isAnagram(String word, String part) {
        if (part == null || part.isEmpty()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            map.computeIfAbsent(c, k -> 0);
            map.put(c, map.get(c) + 1);
        }
        for (int i = 0; i < part.length(); i++) {
            char c = Character.toLowerCase(part.charAt(i));
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}


