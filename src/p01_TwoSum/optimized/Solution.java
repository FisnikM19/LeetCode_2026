package p01_TwoSum.optimized;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[]{map.get(needed), i};
            }

            map.put(nums[i], i);
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