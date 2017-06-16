package Trees.Q_14_Symmetrictree;

import Trees.library.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
      1
    /  \
   2    2
 / \   / \
 3  4  4  3

 But the following [1,2,2,null,3,null,3] is not:
  1
 /  \
 2   2
  \   \
  3    3
 */
public class SymmetricTree {

    /**
     * Solution1 : Recursive
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(final TreeNode l, final TreeNode r) {
        if(l == null && r == null) {
            return true;
        } else if(l == null || r == null) {
            return false;
        }

        if(l.data != r.data) {
            return false;
        }

        if(isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left)) {
            return true;
        }

        return false;
    }

    /**
     * Solution2: Iterative solution using BFS
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_iterative(TreeNode root) {
        if (root == null || root.left == null && root.right == null){
            return true;
        }
        if (root.left == null || root.right == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left.data != right.data){
                return false;
            }

            if (left.left != null && right.right != null){
                queue.offer(left.left);
                queue.offer(right.right);
            }
            else if (left.left == null && right.right != null || right.right == null && left.left != null){
                return false;
            }
            if (left.right != null && right.left != null){
                queue.offer(left.right);
                queue.offer(right.left);
            }
            else if (left.right == null && right.left != null || right.left == null && left.right != null){
                return false;
            }
        }
        return true;
    }
}
