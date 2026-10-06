package p07_ReverseInteger;

public class Solution {

    public int reverse(int x) {

        int res = 0;

        while (x != 0) {

            int lastDigit = x % 10;
            x /= 10;

            // Check positive overflow
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }

            // Check negative overflow
            if (res < Integer.MIN_VALUE / 10 ||
                    (res == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }

            res = res * 10 + lastDigit;
        }

        return res;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.reverse(123));
        System.out.println(sol.reverse(-123));
        System.out.println(sol.reverse(120));
        System.out.println(sol.reverse(1534236469));
    }
}