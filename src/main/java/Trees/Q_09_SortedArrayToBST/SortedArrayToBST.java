package Trees.Q_09_SortedArrayToBST;

import Trees.library.TreeNode;

/**
 * Created by rg029761 on 5/21/17.
 */
public class SortedArrayToBST {
    public TreeNode convert(int [] arrA, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(arrA[mid]);
        root.left = convert(arrA, start, mid-1);
        root.right =convert(arrA, mid+1, end);
        return root;
    }
    public void displayTree(TreeNode root){
        if(root!=null){
            displayTree(root.left);
            System.out.print(" " + root.data);
            displayTree(root.right);
        }
    }
    public static void main(String args[]){
        int [] arrA = {2,3,6,7,8,9,12,15,16,18,20};
        SortedArrayToBST s = new SortedArrayToBST();
        TreeNode x = s.convert(arrA, 0, arrA.length-1);
        System.out.println("Tree Display : ");
        s.displayTree(x);
    }
}
