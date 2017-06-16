package Trees.Q_11_MinimumDepthBinaryTree;

import Trees.library.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 Show Tags
 Show Similar Problems

 */
public class MinDepthBinaryTree {

    /**
     * 1st solution: Can do a BFS or level order traversal.
     *
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
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

    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }
}
