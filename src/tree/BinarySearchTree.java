package tree;

public class BinarySearchTree {

    private TreeNode root;

    private class TreeNode {

        private int data;
        private TreeNode  left;
        private TreeNode  right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    //insert a value in a Binary Search Tree in Java (Recursive)
    public TreeNode insert(TreeNode root, int value){
        if (root == null){
            root = new TreeNode(value);
            return root;
        }
        if (value < root.data ){
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void inOrder(TreeNode root){
        if (root == null) {   //base line recursion thread will be terminated here
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.insert(bst.root, 1);
        bst.insert(bst.root, 2);
        bst.insert(bst.root, 3);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 5);
        bst.inOrder(bst.root);
    }
}
