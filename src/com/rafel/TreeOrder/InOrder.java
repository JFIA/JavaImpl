package com.rafel.TreeOrder;

import java.util.Stack;

public class InOrder implements TreeDef {
    public static void inOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }
}
