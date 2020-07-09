package com.testmodule.leetcodes.leetcode.editor.cn;//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution6 {

    public static void main(String[] args) {
        convert2("r5e3tr7itr9hykmrvfewc5e", 5);
        convert3("r5e3tr7itr9hykmrvfewc5e", 5);
    }

    public static String convert(String s, int numRows) {
        int length = s.length();
        int index = 0;
        String[][] arr = new String[numRows][(15)];
        int r = 0, c = 0;
        while (length > 0) {
            if (isTop(r, numRows)) {
                if (length - numRows < 0) {
                    //不够一列了
                    for (int i = 0; i < length; i++) {
                        arr[r + i][c] = s.substring(index, index + 1);
                        length--;
                        index++;
                    }
                    break;
                } else {
                    for (int i = 0; i < numRows; i++) {
                        arr[r + i][c] = s.substring(index, index + 1);
                        length--;
                        index++;
                    }
                    r = numRows - 2;
                    c++;
                }
            } else if (isBottom(r, numRows)) {
                if (length - numRows + 1 < 0) {
                    //不够填充间距了
                    for (int i = 0; i < length; i++) {
                        arr[r][c] = s.substring(index, index + 1);
                        r--;
                        c++;
                        length--;
                        index++;
                    }
                    break;
                } else {
                    for (int i = 0; i < numRows - 1; i++) {
                        arr[r][c] = s.substring(index, index + 1);
                        r--;
                        c++;
                        length--;
                        index++;
                    }
                    r = 0;
                }
            }
        }
        return "";
    }

    public static boolean isTop(int r, int numRows) {
        if (r % (numRows + 2) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isBottom(int r, int numRows) {
        if ((r + 1 - numRows + 1) % (numRows + 2) == 0) {
            return true;
        }
        return false;
    }

    public static void convert2(String s, int rows) {
        int length = s.length();
        String[] arr = {"", "", "", "", ""};
        int index = 0;
        int flag = 1;
        for (int i = 0; i < length; i++) {
            arr[index] += s.charAt(i);
            index += flag;
            if (index == rows - 1) {
                //到底部了
                flag = -1;
            }
            if (index == 0) {
                flag = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }

    public static String convert3(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        System.out.println("----");
        System.out.println(res.toString());
        return res.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
