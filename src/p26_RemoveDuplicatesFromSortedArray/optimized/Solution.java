package p26_RemoveDuplicatesFromSortedArray.optimized;

public class Solution {

    public int removeDuplicates(int[] nums) {

        int k = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.removeDuplicates(new int[]{1,1,2}));
        System.out.println(sol.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
