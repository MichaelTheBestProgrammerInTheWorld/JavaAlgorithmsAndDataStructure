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

    //search a given key in a Binary Search Tree
    public TreeNode search(TreeNode root, int key){
        if (root == null || root.data == key){
            return root;
        }
        if (key < root.data){
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    //Validate Binary Search Tree
    public boolean isValid(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.data <= min || root.data >= max){
            return false;
        }
        boolean left = isValid(root.left, min, root.data);
        if (left){
            boolean right = isValid(root.right, root.data, max);
            return right;
        }
        return false;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.insert(bst.root, 1);
        bst.insert(bst.root, 2);
        bst.insert(bst.root, 3);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 5);
        bst.inOrder(bst.root);

        System.out.println();

        if (bst.search(bst.root, 5) != null){
            System.out.println("key " + bst.search(bst.root, 5).data + " is found");
        } else {
            System.out.println("key not found");
        }
        if (bst.search(bst.root, 9) != null){
            System.out.println("key " + bst.search(bst.root, 9).data + " is found");
        } else {
            System.out.println("key not found");
        }

        System.out.println("is tree valid? " + bst.isValid(bst.root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
