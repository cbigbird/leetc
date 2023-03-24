package main.java.p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18FourSum {
    public static void main(String[] args) {
        P18FourSum entity = new P18FourSum();
        System.out.println();
        System.out.println(entity.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(entity.fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(entity.fourSum(new int[]{5,5,3,5,1,-5,1,-2}, 4));
        System.out.println(entity.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
        System.out.println();
        System.out.println(entity.nSum(new int[]{1,0,-1,0,-2,2}, 0, 4));
        System.out.println(entity.nSum(new int[]{2,2,2,2,2}, 8, 4));
        System.out.println(entity.nSum(new int[]{5,5,3,5,1,-5,1,-2}, 4, 4));
        System.out.println(entity.nSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296, 4));
        System.out.println(entity.nSum(new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000}, 1000000000, 4));
        System.out.println();
        System.out.println(entity.nSum2(new int[]{1,0,-1,0,-2,2}, 0, 4));
        System.out.println(entity.nSum2(new int[]{2,2,2,2,2}, 8, 4));
        System.out.println(entity.nSum2(new int[]{5,5,3,5,1,-5,1,-2}, 4, 4));
        System.out.println(entity.nSum2(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296, 4));
        System.out.println(entity.nSum2(new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000}, 1000000000, 4));
    }

    public List<List<Integer>> nSum(int[] nums, long target, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums == null || nums.length < n) {
            return result;
        } else if (n < 1) {
            return result;
        } else if (n == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    result.add(Arrays.asList(nums[i]));
                    break;
                } else if (nums[i] > target) {
                    break;
                }
            }
            return result;
        } else if (n == 2) {
            int l = 0;
            int r = nums.length - 1;
            long sum;
            for (int i = 0; i < nums.length && l < r; i++) {
                sum = (long)nums[l] + nums[r];
                if (sum == target) {
                    result.add(Arrays.asList(nums[l], nums[r]));
                    l = l + 1;
                    r = r - 1;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l = l + 1;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r = r - 1;
                    }
                } else if (sum < target) {
                    l = l + 1;
                } else {
                    r = r - 1;
                }
            }
        } else {
            List<List<Integer>> sub;
            List<Integer> element;
            int[] numbs;
            for (int i = 0; i < nums.length - n + 1; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    numbs = new int[nums.length - i - 1];
                    System.arraycopy(nums, i + 1, numbs, 0, nums.length - i - 1);
                    sub = nSum(numbs, (long)target - nums[i], n - 1);
                    for (int j = 0; j < sub.size(); j++) {
                        element = new ArrayList<>(sub.size() + 1);
                        element.add(nums[i]);
                        element.addAll(sub.get(j));
                        result.add(element);
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> list3;
        List<Integer> temp;
        long target3;
        int[] nums3;
        for(int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums3 = new int[nums.length - i - 1];
                System.arraycopy(nums, i + 1, nums3, 0, nums3.length);
                target3 = (long)target - nums[i];
                list3 = threeSum(nums3, target3);
                if (list3.size() > 0) {
                    for (List<Integer> l3 : list3) {
                        temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.addAll(l3);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        int l, r;
        long sum;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                l = i + 1;
                r = nums.length - 1;
                while (l < r) {
                    sum = (long)nums[i] + nums[l] + nums[r];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l = l + 1;
                        r = r - 1;
                        while (nums[l] == nums[l - 1] && l < r) {
                            l = l + 1;
                        }
                        while (nums[r] == nums[r + 1] && l < r) {
                            r = r - 1;
                        }
                    } else if (sum < target) {
                        l = l + 1;
                    } else {
                        r = r - 1;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> nSum2(int[] nums, int target, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        nSum(nums, target, n, 0, nums.length - 1, new ArrayList<>(), result);
        return result;
    }

    private void nSum(int[] nums, long target, int n, int l, int r, List<Integer> path, List<List<Integer>> result) {
        if (r - l + 1 < n || nums[r] * (long)n < target || nums[l] * (long)n > target) {
            return;
        } else if (n == 2) {
            while (l < r) {
                final long sum = nums[l] + nums[r];
                if (sum == target) {
                    path.add(nums[l]);
                    path.add(nums[r]);
                    result.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                    l = l + 1;
                    r = r - 1;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l = l + 1;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r = r - 1;
                    }
                } else if (sum < target) {
                    l = l + 1;
                } else {
                    r = r - 1;
                }
            }
        } else {
            for (int i = l; i < r; i++) {
                if (i == l || nums[i] != nums[i - 1]) {
                    path.add(nums[i]);
                    nSum(nums, target - nums[i], n - 1, i + 1, r, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }
//        System.out.println("---------nSum---------");
//        System.out.println(Arrays.toString(nums));
//        System.out.println(l);
//        System.out.println(r);
//        System.out.println(n);
//        System.out.println(target);
//        System.out.println(path);
//        System.out.println(result);
    }
}
