package Trees.Q_01_Traversals;

import Trees.library.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Given binary tree [3,9,20,null,null,15,7],
    3
  /  \
 /    \
 9    20
      /\
     /  \
   15   7
 return its vertical order traversal as:
 [
 [9],
 [3,15],
 [20],
 [7]
 ]

     3
   /  \
  /    \
  9     8
 /\    /\
 / \ /  \
 4  01   7

 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 */
public class VerticalOrderTraversal {

    public static void verticalOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        traverseInVerticalOrder(root, 0, map);

        for(Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }

    private static void traverseInVerticalOrder(final TreeNode root, final int hd, final Map<Integer, List<Integer>> map) {
        if(root == null) {
            return;
        }
        if(map.containsKey(hd)) {
            map.get(hd).add(root.data);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.data);
            map.put(hd, list);
        }
        traverseInVerticalOrder(root.left, hd - 1, map);
        traverseInVerticalOrder(root.right, hd + 1 , map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);

        VerticalOrderTraversal.verticalOrderTraversal(root);
    }
}
