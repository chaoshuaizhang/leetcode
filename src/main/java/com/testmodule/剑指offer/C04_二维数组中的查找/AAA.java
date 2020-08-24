package com.testmodule.剑指offer.C04_二维数组中的查找;



import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author changePosition
 * @date 2020/7/26/026 17:15
 */
public class AAA {

    class Node{
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }


    private static void reverse(Node root){
        if(root == null){
            return;
        }
        if(root.next == null){
            System.out.println(root);
        }
        Node pre = null;
        Node next = null;
        Node tmp = null;
//        while (root != null){
////            tmp = root.next.next;
////            next = root.next;
////            root.next.next = root;
////            root.next = pre;
////            root = tmp;
////            pre = next;
////        }
////        System.out.println(next);
////        ThreadPoolExecutor threadPoolExecutor = null;
////        threadPoolExecutor.execute(null);
////        Thread thread = new Thread();
////        thread.start();
        byte[][] bytes = new byte[2][3];
////        bytes[1][1] = 0;
        System.out.println(12 >> 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cutRope(5));
//        ListNode l1 = new ListNode(1);
//        l1.next=new ListNode(2);
//        l1.next.next=new ListNode(3);
//        l1.next.next.next=new ListNode(4);
//
//        ListNode l2 = new ListNode(6);
//        l2.next=new ListNode(0);
//        l2.next.next=new ListNode(3);
//        l2.next.next.next=new ListNode(4);
//        System.out.println(solution.FindFirstCommonNode(l1, l2).val);
//        AAA aaa = new AAA();
//        Node _1 = aaa.new Node(1);
//        _1.next = aaa.new Node(2);
//        _1.next.next = aaa.new Node(3);
//        _1.next.next.next = aaa.new Node(4);
//        _1.next.next.next.next = aaa.new Node(5);
//        _1.next.next.next.next.next = aaa.new Node(6);
//        _1.next.next.next.next.next.next = aaa.new Node(7);
//        _1.next.next.next.next.next.next.next = aaa.new Node(8);
//        reverse(_1);
//        int[][] a = {
//            {1, 3, 5, 7, 9},
//            {3, 5, 7, 9, 11},
//            {6, 9, 10, 12, 14},
//            {9, 11, 13, 15, 17},
//            {121, 161, 201, 241, 281}
//        };
//        System.out.println(find(15, arr));
//        int[] a = {4,1,6,8,12,31,9,11,24,753,5,0,7,8,432,4,32,4,5};
////        for(int i = 0; i < a.length ; i++){
////            for(int j=i+1; j < a.length; j++){
////                if(a[i] > a[j]){
////                    int tmp = a[i];
////                    a[i] = a[j];
////                    a[j] = tmp;
////                }
////            }
////        }
//
//        quick(a,0,a.length - 1);
//
//
//        int stamp = 0;
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]+"  ");
//            AtomicStampedReference<String> reference = new AtomicStampedReference<>("初始值",stamp);
//            reference.compareAndSet("初始值", "新值", stamp, stamp + 1);
//
//            AtomicMarkableReference<String> markableReference =
//                    new AtomicMarkableReference<>("初始值", true);
//            markableReference.compareAndSet("初始值", "新值", true, false);
//        }
    }

    static void merge(int[] arr){
        for (int i = 0; i < arr.length; i++) {

        }
    }

    static void quick(int[] arr, int low, int height){
        if(low < height){
            int tmp = getSplit(arr, low, height);
            quick(arr, low, tmp-1);
            quick(arr, tmp+1, height);
        }
    }

    static int getSplit(int[] arr, int low, int heigh){
        int target = arr[low];
        int tmp = low;
        while (low < heigh){
            while (low < heigh && target <= arr[heigh]){
                heigh--;
            }
            if(target > arr[heigh]){
                arr[low] = arr[heigh];
                tmp = heigh;
            }
            while (low < heigh && target >= arr[low]){
                low++;
            }
            if(target < arr[low]){
                arr[heigh] = arr[low];
                tmp = low;
            }
        }
        arr[tmp] = target;
        return tmp;
    }

    public static boolean find(int target, int [][] arr) {
        // 行
        for(int i = 0; i < arr.length; i++){
            // 列
            for(int j =0; j < arr[i].length; j++){
                if(target == arr[i][j]){
                    return true;
                }else if(target < arr[i][j]){
                    if(j == 0){
                        // 小于第一列的元素，则不存在（后边的元素都比第一列大）
                        return false;
                    }else if(j == arr[i].length - 1){
                        // 小于最后一列，说明大于当前行的倒数第二个元素，小于倒数第一个元素，则新起一行倒着找
                        return fun(arr, i+1, j-1, target);
                    }
                }else if(target > arr[i][j]){
                    if(j == arr[i].length - 1){
                        // 到最后一列了，则重新起一行找
                        return fun(arr, i+1, j, target);
                    }
                }
            }
        }
        return false;
    }

    static boolean fun(int[][] arr, int i, int j, int target){
        if(arr[i][j] > target){
            if(j == 0){
                // 不存在
                return false;
            }else{
                return fun(arr, i, j - 1, target);
            }
        }else if(arr[i][j] < target){
            if(i == arr.length - 1 && j == arr[i].length - 1){
                return false;
            }
            return fun(arr, i + 1, j, target);
        }else{
            // 找到
            return true;
        }
    }

}

class AAAAA<T extends AAA>{
    static List<?> list;

    public static void main(String[] args) {
        String o = (String) list.get(0);
    }
}

class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;

    }

    public int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int[] arr = new int[target+1];
        return cut(target, arr);
    }

    private int cut(int target, int[] arr){
        if(target <= 4){
            return target;
        }
        if(arr[target] != 0){
            return arr[target-1];
        }
        int r = 0;
        for(int i = 1; i < target; i++){
            r = Math.max(r, i * cut(target - i, arr));
        }
        arr[target] = r;
        return r;
    }
}