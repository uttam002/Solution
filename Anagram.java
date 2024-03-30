import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int countAnagramPairs(String[] strings) {
        Map<String, Integer> frequency = new HashMap<>();
        int pairs = 0;
      
        for (String str : strings) {
          
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
          
            pairs += frequency.getOrDefault(sortedStr, 0);
            frequency.put(sortedStr, frequency.getOrDefault(sortedStr, 0) + 1);
        }
        return pairs;
    }

    public static void main(String[] args) {
        String[] strings = {"abcd", "dcab", "bacd", "dabc", "abcd"};
        System.out.println("Number of anagram pairs: " + countAnagramPairs(strings));
    }
}
