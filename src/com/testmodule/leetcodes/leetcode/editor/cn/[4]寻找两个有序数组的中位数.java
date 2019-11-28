package com.testmodule.leetcodes.leetcode.editor.cn;//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法
//testmodule submit region begin(Prohibit modification and deletion)

class Solution4 {

    public static void main(String[] args) {
        int[] num1 = new int[]{3, 4, 19, 26, 31};
        int[] num2 = new int[]{3, 5, 8, 11, 26, 29, 35, 55, 67, 101, 102, 103, 105, 106};
        findMedianSortedArrays(num1, num2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            System.out.println(binarySearchCutIndex(nums1, nums2, 0, nums1.length));
        }
        return 0;
    }

    public static int binarySearchCutIndex(int[] nums1, int[] nums2, int left, int right) {
        int length = nums1.length + nums2.length;
        while (left < right) {
            int indexI = (left + right) / 2;
            int indexJ = length / 2 - indexI - 1;
            if (indexJ + 1 > nums2.length && nums1[indexI] > nums2[indexJ + 1]) {
                //左移
                right = indexI - 1;
            }
            if (indexI + 1 < nums1.length && nums2[indexJ] > nums1[indexI + 1]) {
                left = indexI + 1;
            }
            return indexI;
        }
        return -1;
    }


    /**
     * 先排序再查找
     *
     * @param nums
     */
    private static float sortAndFind(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                int tmp = nums[j - 1];
                if (tmp > nums[j]) {
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print("  " + nums[i]);
        }
        System.out.println();
        if (nums.length % 2 != 0) {
            return nums[nums.length / 2];
        } else {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2 - 1]) / 2f;
        }
    }


}
//testmodule submit region end(Prohibit modification and deletion)
