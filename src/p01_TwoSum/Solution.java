package p01_TwoSum;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int i = 0;
        int size = nums.length;

        while (i < size - 1) {

            int j = i + 1;

            while (j < size && nums[i] + nums[j] != target) {
                j++;
            }

            if (j < size) {
                return new int[]{i, j};
            }

            i++;
        }

        return new int[0];
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] arr1 = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(sol.twoSum(arr1, 9)));

        int[] arr2 = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(sol.twoSum(arr2, 6)));

        int[] arr3 = new int[]{3, 3};
        System.out.println(Arrays.toString(sol.twoSum(arr3, 6)));
    }
}