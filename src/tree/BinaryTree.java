package tree;

import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode {

        private int data;
        private TreeNode right, left;

        public TreeNode(int data){
            this.data = data;
        }
    }

    //create binary tree
    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    //traverse tree nodes and display them using recursive function
    public void preOrder(TreeNode root){
        if (root == null) {   //base line
            return;
        }
        System.out.print(root.data + " --> ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //traverse tree nodes and display them using stack
    public void preOrder2(TreeNode root){
        if (root == null) {   //base line
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " --> ");
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
        System.out.println("End of Tree");
    }

    //Recursive Inorder traversal of Binary Tree
    public void inOrder(TreeNode root){
        if (root == null) {   //base line
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        //bt.preOrder(bt.root);
        //bt.preOrder2(bt.root);
        bt.inOrder(bt.root);
    }
}
