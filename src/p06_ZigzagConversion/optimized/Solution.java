package p06_ZigzagConversion.optimized;

import java.util.Arrays;

public class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = true;

        for (int i = 0; i < s.length(); i++) {

            rows[row].append(s.charAt(i));

            if (row == 0) {
                goingDown = true;
            } else if (row == numRows - 1) {
                goingDown = false;
            }

            if (goingDown) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = new StringBuilder();

        Arrays.stream(rows)
                .forEach(result::append);

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
