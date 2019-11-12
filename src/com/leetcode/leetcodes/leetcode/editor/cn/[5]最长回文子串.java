package com.leetcode.leetcodes.leetcode.editor.cn;
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

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {

    public static void main(String[] args) {
        new Solution5().longestPalindrome("123456qwert");
    }

    public String longestPalindrome(String s) {
        if (s != null && !s.equals("")) {
            return null;
        }
        if (s.length() < 3) {
            return s;
        }
        int MAX = 0;
        StringBuilder MAX_STR = new StringBuilder(s);
        String sReverse = MAX_STR.reverse().toString();
        MAX_STR.delete(0, MAX_STR.length());
        for (int i = 0, j = 2; i < s.length(); i++, j++) {

        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
