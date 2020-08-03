package com.rafel.TreeOrder;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class PreOrder implements TreeDef{

    public static void preOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }

    }
}
