package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDepth {
    /**
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * Do level-order traversal and record current level depth, when meet a node which both child is null then return, no need to go farther
     *
     * T(n) = O(n)
     *
     * @param root
     * @return
     */
    public static int minDepth_iterative(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root) ;
        int level = 1;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            while(queueSize > 0) {
                TreeNode node = queue.remove();
                if(node.left == null && node.right == null) {
                    return level;
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                queueSize --;
            }
            level++;
        }
        return level;
    }

    public static int minDepth_recursive(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth_recursive(root.left);
        int right = minDepth_recursive(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }

    //this is nothing but finding height of a binary tree.
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
