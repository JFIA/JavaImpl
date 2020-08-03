package com.rafel.TreeOrder;

public class Main implements TreeDef {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(4);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(3);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;

        InOrder.inOrder(root);
        System.out.println("------");
        PreOrder.preOrder(root);
        System.out.println("------");
        PostOrder.postOrder(root);

    }
}
