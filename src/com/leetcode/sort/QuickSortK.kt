package com.leetcode.sort

class QuickSortK {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var nums = arrayOf(7, 3, 9, 12, 52, 1, 4, -7, 35, 27, 32)
            quick(nums, 0, nums.size)
        }

        /**
         * 快排思想：
         * */
        fun quick(nums: Array<Int>, low: Int, high: Int) {
            var target = nums[low]
            while (low < high && target < nums[high]){

            }
        }

    }
}
