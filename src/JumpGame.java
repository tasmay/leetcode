public class JumpGame {

    private static boolean canJump(int[] nums, int pos) {
        if(pos == nums.length-1) return true;
        if(nums[pos] == 0) return false;
        for(int i=1; i < nums[pos]; i++)
            if (canJump(nums, pos+i)) return true;
        return false;
    }

    public static boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        System.out.println(canJump(nums));
        int input = 234;
        while(input > 0) {
            int digit = input%10;
            input = input/10;
            System.out.println(digit);
        }

    }
}
