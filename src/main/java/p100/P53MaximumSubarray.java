package main.java.p100;

public class P53MaximumSubarray {
    public static void main(String[] args) {
        P53MaximumSubarray entity = new P53MaximumSubarray();
        int[] a1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[] a2 = new int[] {1};
        int[] a3 = new int[] {5,4,-1,7,8};
        System.out.println();
        System.out.println(entity.maxSubArray(a1));
        System.out.println(entity.maxSubArray(a2));
        System.out.println(entity.maxSubArray(a3));
    }

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            val = Math.max(val, 0) + nums[i];
            result = Math.max(result, val);
        }
        return result;
    }
}
