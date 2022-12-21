/*
* https://leetcode.com/problems/container-with-most-water/
* */

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea)
                maxArea = area;
            if (height[left] == height[right]) {
                left++;
                right--;
            }
            else if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
//        int[] heights = new int[]{1,1};
        System.out.println(maxArea(heights));
    }
}
