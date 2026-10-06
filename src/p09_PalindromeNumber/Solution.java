package p09_PalindromeNumber;

public class Solution {

    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        int temp = x;

        int res = 0;

        while (temp != 0) {

            int lastDigit = temp % 10;

            temp /= 10;

            // Check positive overflow
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return false;
            }


            res = res * 10 + lastDigit;
        }

        return res == x;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.isPalindrome(121));
        System.out.println(sol.isPalindrome(-121));
        System.out.println(sol.isPalindrome(10));
    }
}
