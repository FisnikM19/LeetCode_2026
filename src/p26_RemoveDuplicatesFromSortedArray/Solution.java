package p26_RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

public class Solution {

    public int removeDuplicates(int[] nums) {

        int duplicate = 0;
        int k = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            int j = i + 1;

            while (j < nums.length && nums[i] == nums[j]) {
                duplicate++;
                j++;
            }

            if (j == nums.length) {
                nums[k + 1] = nums[j - 1];
            } else {
                nums[k + 1] = nums[j];
            }

            i = j - 1;
            k++;
        }

        nums = Arrays.copyOf(nums, nums.length - duplicate);

        return nums.length;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.removeDuplicates(new int[]{1,1,2}));
        System.out.println(sol.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
