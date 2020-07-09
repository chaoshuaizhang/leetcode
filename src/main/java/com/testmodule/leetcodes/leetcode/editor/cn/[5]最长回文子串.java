package com.testmodule.leetcodes.leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

//testmodule submit region begin(Prohibit modification and deletion)
class Solution5 {

    public static void main(String[] args) {
    }

    /**
     * 暴力穷举
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String maxStr = "";
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                int tmpLength = j - i;
                if (tmpLength <= max) {
                    continue;
                }
                int k;
                for (k = 0; k < tmpLength / 2; k++) {
                    if (s.charAt(i + k) != s.charAt(i + tmpLength - 1 - k)) {
                        break;
                    }
                }
                if (k == tmpLength / 2) {
                    maxStr = s.substring(i, j);
                    max = tmpLength;
                }
            }
        }
        return maxStr;
    }

    public String centerExpansion(String s) {

        return "";
    }
}
//testmodule submit region end(Prohibit modification and deletion)
