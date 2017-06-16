package Trees.Q_07_PathSum;

import Trees.library.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
       5
     /   \
    4     8
   /     /  \
  11    13   4
 /  \      / \
 7   2   5   1

 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class FindPathSum {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        pathSum(root, sum, res, path);
        return res;
    }

    private static void pathSum(final TreeNode root, final int sum, final List<List<Integer>> res, List<Integer> path) {
        path.add(root.data);
        if(sum - root.data == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(path));
        }
        if(root.left != null) pathSum(root.left, sum - root.data, res, path);
        if(root.right != null)  pathSum(root.right, sum - root.data, res, path);
        path.remove(path.size() - 1);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }
}
