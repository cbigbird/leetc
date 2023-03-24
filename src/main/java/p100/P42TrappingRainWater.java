package main.java.p100;

public class P42TrappingRainWater {
    public static void main(String[] args) {
        P42TrappingRainWater entity = new P42TrappingRainWater();
        int[] arr1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1}; // 6
        int[] arr2 = new int[]{4,2,0,3,2,5}; // 9
        System.out.println();
        System.out.println(entity.trapII(arr1));
        System.out.println(entity.trapII(arr2));
        System.out.println();
        System.out.println(entity.trap(arr1));
        System.out.println(entity.trap(arr2));
    }

    public int trap(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            while (height[l] == 0 && l < r) {
                l = l + 1;
            }
            while (height[r] == 0 && l < r) {
                r = r - 1;
            }
            int h = Math.min(height[l], height[r]);
            result = result + h * (r - l + 1);
            for (int i = l; i <= r; i++) {
                result = result - Math.min(h, height[i]);
                height[i] = height[i] - Math.min(h, height[i]);
            }
        }
        return result;
    }

    public int trapII(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];
        while (l < r) {
            if (lMax < rMax) {
                lMax = Math.max(lMax, height[l + 1]);
                result = result + lMax - height[l + 1];
                l = l + 1;
            } else {
                rMax = Math.max(rMax, height[r - 1]);
                result = result + rMax - height[r - 1];
                r = r - 1;
            }
        }
        return result;
    }
}
