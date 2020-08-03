package com.rafel.TreeOrder;

import java.util.Stack;

public class PostOrder implements TreeDef{
    /***
     * 树后续非递归，首先逆后序遍历是先序遍历左右相反，
     * 因此用类似层次遍历思想，用栈存储遍历结果，
     * 再用栈存储逆后序结果，逆序输出即为后续遍历结果。
     * @param root
     */
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> src = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        src.push(root);
        while(!src.isEmpty()){
            TreeNode p = src.pop();
            res.push(p);
            if(p.left != null){
                src.push(p.left);
            }
            if(p.right != null){
                src.push(p.right);
            }
        }
        //输出最终后序遍历的结果
        while(!res.isEmpty()){
            System.out.print(res.pop().val + " ");
        }
    }
}
