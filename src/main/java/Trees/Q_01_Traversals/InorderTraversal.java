package Trees.Q_01_Traversals;

import Trees.library.BinarySearchTree;
import Trees.library.TreeNode;

import java.util.Stack;

public class InorderTraversal {

    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void inorder_iterative(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        root = root.left;
        TreeNode curr = root;

        while(!stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode n = stack.pop();
            System.out.println(n.data);
            curr = n.right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst2 = new BinarySearchTree(50);
        bst2.add(40);
        bst2.add(30);
        bst2.add(42);
        bst2.add(41);
        bst2.add(35);
        bst2.add(80);
        bst2.add(75);
        bst2.add(90);

        InorderTraversal.inorder_iterative(bst2.root);
    }
}
