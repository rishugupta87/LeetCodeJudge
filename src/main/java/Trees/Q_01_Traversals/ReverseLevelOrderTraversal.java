package Trees.Q_01_Traversals;

import Trees.library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by
 level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
    3
  /  \
 9   20
    /  \
   15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 *
 *
 */
public class ReverseLevelOrderTraversal {

    // just do normal level order traversal and push results to stack for each level of node traversed.
    public static void reverseLevelOrderTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        Stack<List<Integer>> stack = new  Stack<List<Integer>>();

        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> nodesAtLevel = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode n = queue.remove();
                nodesAtLevel.add(n.data);
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
                count--;
            }
            stack.push(nodesAtLevel);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.left = new TreeNode(9);
        ReverseLevelOrderTraversal.reverseLevelOrderTraversal(root);
    }
}
