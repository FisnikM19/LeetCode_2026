package p27_RemoveElement;

public class Solution {

    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(sol.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
