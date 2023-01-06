package p100;

public class P45JumpGameII {
    public static void main(String[] args) {
        P45JumpGameII entity = new P45JumpGameII();
        int[] arr1 = new int[]{2,3,1,1,4};
        int[] arr2 = new int[]{2,3,0,1,4};
        int[] arr3 = new int[]{0};
        int[] arr4 = new int[]{1,2,3};
        int[] arr5 = new int[]{1,1,1,2,1};
        System.out.println();
//        System.out.println(entity.jump(arr1));
//        System.out.println(entity.jump(arr2));
//        System.out.println(entity.jump(arr3));
//        System.out.println(entity.jump(arr4));
        System.out.println(entity.jump(arr5));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else {
            int result = 0;
            int curr = 0;
            int maxValue = 0;
            int maxIndex = 0;

            while (curr + nums[curr] < nums.length - 1) {
                maxValue = 0;
                for (int i = curr; i < nums.length && i <= curr + nums[curr]; i++) {
                    if (nums[i] + i > maxValue) {
                        maxValue = nums[i] + i;
                        maxIndex = i;
                    }
                }
                curr = maxIndex;
                result = result + 1;
            }
            return result + 1;
        }
    }
}
