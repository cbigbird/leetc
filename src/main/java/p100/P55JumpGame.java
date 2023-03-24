package main.java.p100;

public class P55JumpGame {
    public static void main(String[] args) {
        P55JumpGame entity = new P55JumpGame();
        int[] a1 = new int[] {2,3,1,1,4};
        int[] a2 = new int[] {3,2,1,0,4};
        int[] a3 = new int[] {2,0};
        int[] a4 = new int[] {1,2,3};
        int[] a5 = new int[] {2,0,1,1,2,1,0,0,0};
        int[] a6 = new int[] {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println();
        System.out.println(entity.canJump(a1));
        System.out.println(entity.canJump(a2));
        System.out.println(entity.canJump(a3));
        System.out.println(entity.canJump(a4));
        System.out.println(entity.canJump(a5));
        System.out.println(entity.canJump(a6));
    }

    public boolean canJump(int[] nums) {
        return df(nums, 0);
    }

    private boolean df(int[] nums, int start) {
        int end = nums.length - 1;
        if (start >= end || start + nums[start] >= end) {
            return true;
        } else {
            int max = 0;
            int index = 0;
            for (int i = start + 1; i <= start + nums[start]; i++) {
                if (nums[i] + i > max) {
                    max = nums[i] + i;
                    index = i;
                }
            }
            return max != 0 && df(nums, index);
        }
    }
}
