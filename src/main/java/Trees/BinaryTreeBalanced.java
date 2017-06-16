//package Trees;
//
//import Trees.library.BinaryTree;
//
///**
// * Created by rg029761 on 1/19/17.
// */
//public class BinaryTreeBalanced {
//
//    /**
//     * Top down approach.
//     * he first method checks whether the tree is balanced strictly according to the definition of
//     * balanced binary tree: the difference between the heights of the two sub trees are not bigger than 1,
//     * and both the left sub tree and right sub tree are also balanced.
//     *
//     *
//     *  For the current node root, calling depth() for its left and right children actually has
//     *  to access all of its children, thus the complexity is O(N). We do this for each node in the tree,
//     *  so the overall complexity of isBalanced will be O(N^2).
//     *
//     * @param root
//     * @return
//     */
//    public static boolean isBalanced_TopDown(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//
//        if(Math.abs(BinaryTree.height(root.left) - BinaryTree.height(root.right)) > 1) {
//            return false;
//        }
//        return isBalanced_TopDown(root.left) && isBalanced_TopDown(root.right);
//    }
//
//    /**
//     *
//     *
//     * @param root
//     * @return
//     */
//    public static boolean isBalanced_BottomUp(TreeNode root) {
//       return height(root) != -1;
//    }
//
//    private static int height(TreeNode root) {
//        if(root == null) {
//            return 0;
//        }
//        int leftHeight = height(root.left);
//        if(leftHeight == -1) return -1;
//        int rightHeight = height(root.right);
//        if(rightHeight == -1) return -1;
//
//        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
//
//        return 1 + Math.max(leftHeight, rightHeight);
//    }
//}
