package p08_StringToInteger;

public class Solution {

    public int myAtoi(String s) {

        int i = 0;

        // 1. Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Determine sign
        int sign = 1;

        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        // 3. Read digits
        int res = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // 4. Check overflow
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && digit > 7)) {

                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            res = res * 10 + digit;

            i++;
        }

        return res * sign;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.myAtoi("42"));
        System.out.println(sol.myAtoi(" -042"));
        System.out.println(sol.myAtoi("1337c0d3"));
        System.out.println(sol.myAtoi("0-1"));
        System.out.println(sol.myAtoi("words and 987"));
        System.out.println(sol.myAtoi("-91283472332"));
    }
}