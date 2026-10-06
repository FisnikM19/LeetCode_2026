package p28_FindTheIndexOfTheFirstOccurrenceInString;

public class Solution {

    public int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.strStr("sadbutsad", "sad"));
        System.out.println(sol.strStr("leetcode", "leeto"));
    }


}
