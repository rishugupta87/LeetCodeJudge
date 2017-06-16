package Trees.Q_07_PathSum;

import Trees.library.TreeNode;

/**
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
 along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
      5
     /  \
    4    8
   /    /  \
  11  13   4
 / \        \
 7  2        1

 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class HasPathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(sum - root.data == 0 && root.left == null && root.right == null) {
            return true;
        }
        //if first condition is true it doesn traverse right.
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }
}
