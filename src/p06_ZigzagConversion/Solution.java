package p06_ZigzagConversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        Map<Integer, List<Character>> map = new HashMap<>();

        boolean flag = false;
        int diagonal = numRows - 2;

        for (int i = 0; i < s.length();) {

            if (!flag) {
                int j = 0;
                while (i < s.length() && j < numRows) {
                    map.computeIfAbsent(j, k -> new ArrayList<>()).add(s.charAt(i++));
                    j++;
                }
                flag = true;
            } else {
                int j = diagonal;
                while (i < s.length() && j >= 1) {
                    map.computeIfAbsent(j, k -> new ArrayList<>()).add(s.charAt(i++));
                    j--;
                }
                flag = false;
            }
        }

        StringBuilder result = new StringBuilder();

        for (List<Character> list : map.values()) {
            for (Character c : list) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";

        Solution sol = new Solution();

        System.out.println(sol.convert("AB", 1));
        System.out.println(sol.convert(s, 3));
        System.out.println(sol.convert(s, 4));
    }
}
