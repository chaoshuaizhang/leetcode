package com.testmodule.query;

/**
 * 二分查找
 *
 * @author Administrator
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 8, 15};
        System.out.println(searchIndex(num, 8, 0, num.length - 1));
        System.out.println(searchIndex2(num, 8, 0, num.length - 1));
    }

    /**
     * 递归实现
     *
     * @param num
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int searchIndex(int[] num, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (num[middle] < target) {
            return searchIndex(num, target, middle + 1, right);
        }
        if (num[middle] > target) {
            return searchIndex(num, target, left, middle - 1);
        }
        //上边的两个判断是middle小于或者大于tagrget，那么走到这里的时候，肯定是等于了
        return middle;
    }

    /**
     * 循环实现
     *
     * @param num
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int searchIndex2(int[] num, int target, int left, int right) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (num[middle] < target) {
                left = middle++;
                continue;
            }
            if (num[middle] > target) {
                right = middle--;
                continue;
            }
            return middle;
        }
        return -1;
    }


}
