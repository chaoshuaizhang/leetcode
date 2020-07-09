package com.testmodule.sort;

import java.util.Arrays;

public class DirectInsertSort {
    public static void main(String[] args) {
        int[] nums = {7, 3, 9, 12, 52, 1, 4, -7, 35, 27, 32};
        directInsert(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(String.format("%s%d", " ", n)));
    }

    private static void directInsert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //得到当前待排序的元素
            int currNum = nums[i];
            //这里用倒序插入简单点-从后便开始往前比较
            int move = 0;
            //拿第i个元素与0---(i-1)之间的所有元素进行比较，注意这里不是>0，而是>=0
            //当i=3的时候，需要拿num[3]和num[2-0]
            for (int j = i - 1; j >= 0; j--) {
                //循环对比已经排好序的，插入在适当的位置
                if (currNum < nums[j]) {
                    //后移一个位置
                    move++;
                } else {
                    //碰到比自己大的或者相等的，说明已经
                    break;
                }
            }
            int m = i;
            for (; move > 0; move--, m--) {
                nums[m] = nums[m - 1];
            }
            nums[m] = currNum;
        }
    }
}
