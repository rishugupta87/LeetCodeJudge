package Trees.Q_13_BalancedBinaryTree;

import Trees.library.TreeNode;

/**
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the
 two subtrees of every node never differ by more than 1.
 */
public class IsBalancedBinaryTree {

    /**
     *
     If we inspect this method, we may notice that getHeight could actually check if the tree is balanced at the same
     time as it's checking heights. What do we do when we discover that the subtree isn't balanced? Just return an error code.
     This improved algorithm works by checking the height of each subtree as we recurse down from the root. On each node,
     we recursively get the heights of the left and right subtrees through the checkHeight method. If the subtree is balanced,
     then checkHeight will return the actual height of the subtree. If the subtree is not balanced, then checkHeight will
     return an error code. We will immediately break and return an error code from the current call.
     *
     * @param root
     * @return
     */
    public static boolean isBalancedBinaryTree_Efficient(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(final TreeNode root) {
        if(root == null) {
            return 0;
        }
        int hLeft = checkHeight(root.left);
        if(hLeft == -1) return -1;
        int hright = checkHeight(root.right);
        if(hright == -1) return -1;

        if(Math.abs(hLeft - hright) > 1) {
            return -1;
        }
        return 1 + Math.max(hLeft, hright);
    }
}
