package com.testmodule.leetcodes.leetcode.editor.cn;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按
// 照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


//testmodule submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode n1 = new ListNode(5);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        n2.next.next.next = new ListNode(7);
        ListNode listNode = solution2.addTwoNumbers3(n1, n2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode listNode = new ListNode(0);
        ListNode tmp = listNode;
        while (l1 != null || l2 != null || jinwei != 0) {
            int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + jinwei;
            if (num > 9) {
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            tmp.val = num % 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            //只要有一个还没遍历完成，就再构造一个next节点
            //之前想着一个完成以后，直接把尾部指向未遍历完成的那部
            // 分就行，但这是不行的，因为如果有进位1，并且未完成部分是999，则不能直接指向
            if (l1 != null || l2 != null || jinwei != 0) {
                tmp.next = new ListNode(0);
            }
            tmp = tmp.next;
        }
        return listNode;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode tmp = listNode;
        while (l1 != null || l2 != null) {
            int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (tmp == null ? 0 : tmp.val);
            tmp.val = num % 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            //只要有一个还没遍历完成，就再构造一个next节点
            //之前想着一个完成以后，直接把尾部指向未遍历完成的那部
            // 分就行，但这是不行的，因为如果有进位1，并且未完成部分是999，则不能直接指向
            if (num > 9) {
                tmp.next = new ListNode(1);
            } else {
                tmp.next = new ListNode(0);
            }
            if (l1 == l2) {
                if (tmp.next.val == 0) {
                    tmp.next = null;
                }
            } else {
                tmp = tmp.next;
            }

        }
        return listNode;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode tmp = listNode;
        while (l1 != l2) {
            int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (tmp == null ? 0 : tmp.val);
            tmp.val = num % 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            //只要有一个还没遍历完成，就再构造一个next节点
            //之前想着一个完成以后，直接把尾部指向未遍历完成的那部
            // 分就行，但这是不行的，因为如果有进位1，并且未完成部分是999，则不能直接指向

            //这里只有l1==null l2==null时才会成立
            if (l1 == l2) {
                if (num / 10 != 0) {
                    tmp.next = new ListNode(num / 10);
                }
            } else {
                tmp.next = new ListNode(num / 10);
                tmp = tmp.next;
            }

        }
        return listNode;
    }

}
//testmodule submit region end(Prohibit modification and deletion)
