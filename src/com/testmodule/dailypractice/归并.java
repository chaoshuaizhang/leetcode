package com.testmodule.dailypractice;

public class 归并 {
    public static void main(String[] args) {
        int[] num1 = new int[]{3, 652, 4, 6, 31, 76, 42, 45, 5};
        int[] num2 = new int[]{43, 56, 3, 67, 26, 743, 23, 565, 134, 31, 35, 645, 23};
        merge(num1, num2);
    }
    /**
     * 归并两个有序数组
     *
     * @param nums1
     * @param nums2
     */
    private static void merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int count = 0;
        int i;
        int j = 0;
        for (i = 0; i < nums1.length; ) {
            for (j = 0; j < nums2.length && i < nums1.length; ) {
                if (nums1[i] < nums2[j]) {
                    nums[count++] = nums1[i++];
                } else {
                    nums[count++] = nums2[j++];
                }
            }
        }
        for (; i < nums1.length; i++) {
            nums[count++] = nums1[i];
        }
        for (; j < nums2.length; j++) {
            nums[count++] = nums2[j];
        }
        //输出归并后的数据
        for (int k = 0; k < nums.length; k++) {
            System.out.print("  " + nums[k]);
        }
    }
}
