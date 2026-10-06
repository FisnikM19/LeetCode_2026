package p13_RomanToInt;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int romanToInt(String s) {


        int num = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 1; i < s.length(); i++) {

            char c = s.charAt(i);

            switch (c) {
                case 'I':
                    num += 1;
                    break;
                case 'V':
                    if (s.charAt(i - 1) == 'I') {
                        num += 3;
                    } else {
                        num += 5;
                    }
                    break;
                case 'X':
                    if (s.charAt(i - 1) == 'I') {
                        num += 8;
                    } else {
                        num += 10;
                    }
                    break;
                case 'L':
                    if (s.charAt(i - 1) == 'X') {
                        num += 30;
                    } else {
                        num += 50;
                    }
                    break;
                case 'C':
                    if (s.charAt(i - 1) == 'X') {
                        num += 80;
                    } else {
                        num += 100;
                    }
                    break;
                case 'D':
                    if (s.charAt(i - 1) == 'C') {
                        num += 300;
                    } else {
                        num += 500;
                    }
                    break;
                case 'M':
                    if (s.charAt(i - 1) == 'C') {
                        num += 800;
                    } else {
                        num += 1000;
                    }
                    break;
                default:
                    break;
            }
        }

        return num + map.get(s.charAt(0));
    }

    public static void main(String[] args) {

        Solution sol = new Solution();


        System.out.println(sol.romanToInt("III"));
        System.out.println(sol.romanToInt("LVIII"));
        System.out.println(sol.romanToInt("MCMXCIV"));
    }
}
