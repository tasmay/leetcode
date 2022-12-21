/*
* https://leetcode.com/problems/product-of-array-except-self/
* */

public class ProductExceptSelf {

    public static int[] productExceptSelfNaive(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int product = 1;
            for (int j=0; j<nums.length; j++) {
                if (i!=j)
                    product = product * nums[j];
            }
            ans[i] = product;
        }
        return ans;
    }

    public static int[] productExceptSelf(int[] nums) {
        int SIZE = nums.length;
        int[] result = new int[SIZE];

        int temp = 1;
        for(int i=0; i<SIZE; i++) {
            if(i>0){
                temp = temp * nums[i-1];
            }
            result[i] = temp;
        }
        temp = 1;
        for(int i=SIZE-1; i>=0; i--) {
            if (i<SIZE-1) {
                temp = temp * nums[i+1];
            }
            result[i] = result[i] * temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);

        for (int i=0; i<result.length; i++)
            System.out.println(result[i]);
    }
}
