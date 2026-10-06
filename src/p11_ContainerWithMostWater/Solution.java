package p11_ContainerWithMostWater;

public class Solution {

    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1;

        int maxLen = 0;

        while (i < j) {

            maxLen = Math.max(maxLen, Math.min(height[i], height[j]) * (j - i));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }

        return maxLen;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] arr1 = new int[]{1,8,6,2,5,4,8,3,7};
        int[] arr2 = new int[]{1, 1};

        System.out.println(sol.maxArea(arr1));
        System.out.println(sol.maxArea(arr2));
    }
}
