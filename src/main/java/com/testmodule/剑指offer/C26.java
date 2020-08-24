package com.testmodule.剑指offer;

/**
 * @author changePosition
 * @date 2020/7/26/026 11:10
 */
public class C26 {
    public static void main(String[] args) {

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        while(root1 != null){
            while(root2 != null){
                if(root1.val == root2.val){
                    if(root1.left != null && root2.left != null && root1.right != null && root2.right != null){
                        return HasSubtree(root1.left, root2.left) && HasSubtree(root1.right, root2.right);
                    }
                    if(root1.left != null && root2.left != null && root1.right == null && root2.right == null){
                        return HasSubtree(root1.left, root2.left);
                    }
                    if(root1.left == null && root2.left == null && root1.right != null && root2.right != null){
                        return HasSubtree(root1.left, root2.left) && HasSubtree(root1.right, root2.right);
                    }
                    return true;
                }
            }
        }
        return false;
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}