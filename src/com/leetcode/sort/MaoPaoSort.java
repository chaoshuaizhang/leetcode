package com.leetcode.sort;

import com.leetcode.testKotlin.TestKotlin;

/**
 * @author Administrator
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        maoPao(new int[]{3, 6, 31, 9, 12, 19, 42, 13});
        System.out.println();
        maoPao2(new int[]{3, 6, 31, 9, 12, 19, 42, 13});
        System.out.println();
        maoPao3(new int[]{3, 6, 31, 9, 12, 19, 42, 13});
    }


    /**
     * 冒泡排序：
     * 第一个for循环的意思是需要多少趟
     * 第二个for循环的意思是每一趟中（a,b,c,d），相邻的两个数---进行比较a和b比较，如果a>b就交换a和b的顺序，此时变为了b,a,c,d
     * 然后比较a和c，如果a<c则不变，继续比较相邻的c和d，按照上述思路。
     * 【自己以前的思路是错误的，拿第一个a和接下来bcd比较一圈，这是不对的，应该是拿当前最大比较一圈，比如a没有c大，后续就没有a的事了】
     * 注意第二个for循环中j的边界：j < nums.length-i-1，减1的原因是循环体里的j有j+1操作，减i是因为每一趟都会固定一个相对最大
     * 值，所以下次只需要排接下来的那些数据就行。
     *
     * @param nums
     */
    static void maoPao(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //交换
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 想一个问题：加入一趟下来没有发生任何交换，说明什么？说明后一个都比前一个大，那也就是有序的啊，所以：
     * 当一趟下来没有任何交换时，就退出排序
     *
     * @param nums
     */
    static void maoPao2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //一趟下来是否进行过交换
            boolean change = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 试想一下：
     * 一个元素时需要几趟？0躺
     * 两个个元素时需要几趟？1躺
     * 3个元素时需要几趟？2躺
     * 【可以这么想】：当只剩下一个元素未排序时---即n-1个大值都放在后面了，那剩下的
     * 肯定是最小的了，所以最后一趟不需要排序了
     *
     * @param nums
     */
    static void maoPao3(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean change = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
