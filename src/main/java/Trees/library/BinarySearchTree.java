package Trees.library;

import Trees.BinaryTreePrinter;

/**
 * Created by rg029761 on 5/18/17.
 */
public class BinarySearchTree {

    public TreeNode root;

    public BinarySearchTree(int data) {
        root = new TreeNode(data);
    }

    public void add(int data) {
        TreeNode nodeToAdd = new TreeNode(data);
        addNodetoBST(nodeToAdd, root);
    }

    public void addNodetoBST(TreeNode nodeToAdd, TreeNode root) {
        if(nodeToAdd.data < root.data) {
            if(root.left == null) {
                root.left = nodeToAdd;
            } else {
                addNodetoBST(nodeToAdd, root.left);
            }
        } else {
            if(root.right == null) {
                root.right = nodeToAdd;
            } else {
                addNodetoBST(nodeToAdd, root.right);
            }
        }
    }

    public void delete(int data) {
        TreeNode prevNode = null;
        TreeNode currNode = root;

        while(currNode.data != data) {
            if(data < currNode.data) {
                prevNode = currNode;
                currNode = currNode.left;
            } else {
                prevNode = currNode;
                currNode = currNode.right;
            }
        }

        //found a match at this point.
        if(currNode.left != null && currNode.right != null) { //both left and right child are present
            //replace current node with leftmost child in right subtree or rightmost child in left subtree
            prevNode = currNode; //keep track of previous node which is to be deleted
            currNode = currNode.right;
            TreeNode tmp = null; //keep track of parent

            //find the smallest node
            while(currNode.left != null) {
                tmp = currNode;
                currNode = currNode.left;
            }
            prevNode.data = currNode.data;

            if(tmp == null) { //check deleting 70 to understand why we did this
                tmp = prevNode;
            }
            if(currNode.data >= tmp.data) {
                tmp.right = currNode.right;
            } else {
                tmp.left = currNode.left;
            }
        } else if(currNode.left == null && currNode.right == null) { //left node
            if(currNode.data < prevNode.data) {
                prevNode.left = null;
            } else {
                prevNode.right = null;
            }
        } else { //has one child
            if(currNode.data > prevNode.data) {
                prevNode.right = currNode.left == null ? currNode.left : currNode.right;
            } else {
                prevNode.left = currNode.left == null ? currNode.left : currNode.right;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(60);
        bst.add(50);
        bst.add(75);
        bst.add(70);
        bst.add(80);
        bst.add(55);
        bst.add(45);
        bst.add(90);

        BinarySearchTree bst2 = new BinarySearchTree(50);
        bst2.add(40);
        bst2.add(30);
        bst2.add(42);
        bst2.add(41);
        bst2.add(35);
        bst2.add(80);
        bst2.add(75);
        bst2.add(90);
        System.out.println("before  deletion");


    }
}
