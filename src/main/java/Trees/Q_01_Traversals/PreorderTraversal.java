package Trees.Q_01_Traversals;

import Trees.library.BinarySearchTree;
import Trees.library.TreeNode;

import java.util.Stack;

public class PreorderTraversal {

    public static void preorder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * root, left., right
     * @param root
     */
    public static void preOrderTraversal_Iterative(final TreeNode root) {
        TreeNode top;
        if (root == null)
            return;

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        /*
         * Push the root and do the same process as recursive one but in this way:
         * a) Print the node's data
         * b) Push its right child
         * c) Push its left child.
         * This is done because stack if LIFO so left child is operated first.
         */
        while (!st.empty()) {
            top = st.pop();
            System.out.print(top.data + " ");
            if (top.right != null)
                st.push(top.right);
            if (top.left != null)
                st.push(top.left);
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

        PreorderTraversal.preOrderTraversal_Iterative(bst2.root);
    }
}
