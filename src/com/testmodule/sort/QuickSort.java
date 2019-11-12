package com.testmodule.sort;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {7, 3, 9, 12, 52, 1, 4, -7, 35, 27, 32};
        quick(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(n -> System.out.print(String.format("%s%d", " ", n)));
    }

    /**
     * @param nums
     * @param low
     * @param hight
     */
    private static void quick(int[] nums, int low, int hight) {
        //注意这个边界，不要忘了
        if (low < hight) {
            //1. 拿到分隔的那个位置---即固定好元素了的那个位置（因为这个位置左边的都小，右边的都大，
            // 所以这个位置的数据以后就不需要再排序了）
            int split = getSplitPosition(nums, low, hight);
            //2. split-1的目的就是不排序split位置上的数据
            quick(nums, low, split - 1);
            //3. split+1的目的就是不排序split位置上的数据
            quick(nums, split + 1, hight);
        }
    }

    private static int getSplitPosition(int[] nums, int low, int hight) {
        //拿到一个目标值，以这个值为界，划分左右两个区域
        int target = nums[low];
        while (low < hight) {
            while (low < hight && target <= nums[hight]) {
                //说明不需要交换，hight向前移动一位
                hight--;
            }
            //说明low<hight了 或者 碰到比target小的了，怎么办？交换，把小的放到到前边
            nums[low] = nums[hight];

            while (low < hight && target >= nums[low]) {
                low++;
            }
            //说明low<hight了 或者 碰到比target大的了，怎么办？交换，把大的放到到后边
            nums[hight] = nums[low];
        }

        //放置目标值，放置后这个位置以后就不再参与排序
        nums[low] = target;
        //返回目标值的位置
        return low;
    }

}
