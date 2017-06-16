package Trees.Q_03_KthSmallestElementBST;

import Trees.Q_01_Traversals.InorderTraversal;
import Trees.library.BinarySearchTree;
import Trees.library.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ? k ? BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementBST {

    /**
     * 1st solution. just inorder traversal and storing result in count object.
     *
     * @param root
     * @param k
     * @return
     */
    public static int findKthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        Count count = new Count(0);
        Count resultCount = new Count(0); // to note down the result when k is encountered. this is better than using a static variable.

        findKthSmallest(root, k, count, resultCount);

        return resultCount.countVal;
    }

    /**
     *  Follow up 2nd solution: just do normal inorder traversal and put results in array list
     *
     * @param root
     * @param k
     * @return
     */
    public static int findKthSmallest2(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<Integer>();
        findKthSmallest2(root, k, list);

        return list.get(k-1);
    }

    private static void findKthSmallest2(final TreeNode root, final int k, final List<Integer> list) {
        if(root == null) {
            return;
        }
        findKthSmallest2(root.left, k, list);
        list.add(root.data);
        findKthSmallest2(root.right, k, list);
    }

    private static int findKthSmallest(final TreeNode root, final int k, final Count count, final Count resultCount) {
        if(root == null) {
            return 0;
        }

        findKthSmallest(root.left, k, count, resultCount);
        count.countVal++;

        if(count.countVal == k) {
            resultCount.countVal = root.data;
            return resultCount.countVal; //already got the result, try to avoid further traversing.
        }

        if(resultCount.countVal == 0) { //to avoid traversing right subtree, optimization
            return findKthSmallest(root.right, k, count, resultCount);
        }
        return -1;
    }

    static class Count {
        int countVal;
        public Count(int count) {
            this.countVal = count;
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

        InorderTraversal.inorder(bst2.root);

        System.out.println(KthSmallestElementBST.findKthSmallest2(bst2.root, 8));
    }
}
