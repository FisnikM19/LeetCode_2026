package p03_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int j = i; j < s.length(); j++) {

                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                count++;
            }
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }
}
