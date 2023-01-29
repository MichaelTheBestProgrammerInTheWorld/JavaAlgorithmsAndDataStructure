package tree;

import java.util.LinkedList;
import java.util.Queue;
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
        if (root == null) {   //base line recursion thread will be terminated here
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //Iterative Inorder traversal of a Binary Tree
    public void iterativeInOrder(TreeNode root){
        if (root == null) {   //base line
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data  + " --> ");
                temp = temp.right;
            }
        }
        System.out.println("End of Tree");
    }

    //Recursive Postorder traversal of a Binary Tree
    public void postOrderRecursive(TreeNode root){
        if (root == null) {   //base line recursion thread will be terminated here
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    //Iterative Postorder Traversal of a Binary Tree
    public void postOrderiterative(TreeNode root){
        if (root == null) {   //base line recursion thread will be terminated here
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data + " --> ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " --> ");
                    }
                } else {
                    current = temp;
                }
            }
        }
        System.out.println("End of Tree");
    }

    //Level order traversal of a Binary Tree
    public void levelOrderTraversal(TreeNode root){
        if (root == null) {   //base line recursion thread will be terminated here
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " --> ");
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
        }
        System.out.println("End of Tree");
    }

    //find Maximum value in a Binary Tree (Recursive)
    public int findMaxRecursive(TreeNode root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMaxRecursive(root.left);
        int right = findMaxRecursive(root.right);
        if (left > result){
            result = left;
        }
        if (right > result){
            result = right;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        System.out.println("Pre-Order");
        //bt.preOrder(bt.root);
        bt.preOrder2(bt.root);
        System.out.println("In-Order");
//        bt.inOrder(bt.root);
//        System.out.println();
        bt.iterativeInOrder(bt.root);
        System.out.println("Post-Order");
        //bt.postOrderRecursive(bt.root);
        bt.postOrderiterative(bt.root);
        System.out.println("Level-Order Traversal");
        bt.levelOrderTraversal(bt.root);
        System.out.println("Find MAx");
        System.out.println(bt.findMaxRecursive(bt.root));
    }
}
