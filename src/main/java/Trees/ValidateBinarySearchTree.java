package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ValidateBinarySearchTree {

    /* ------------------------------------------------Method 1-------------------------------------------------------------------------------------*/
    // can do inorder traversal, check if elements are sorted. Time O(n),
    // Auxiliary Space : If we don’t consider size of stack for function calls then O(1) otherwise O(n).
    // The only space usage in your code comes from elements in your Stack<>. Since, as you observed in the question,
    // the size of Stack<> at any point is the depth of the current node(i.e., distance from the root), the space complexity of your algorithm is O(height).
    // If you have a balanced binary tree, for example, O(height) could be as low as O(log V), where V is the number of vertices in your tree. In the worst case, O(height) = O(V).
    public boolean isValidBST(TreeNode root) {

        //can do inorder traversal
        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root, list);

        //iterate over the list and see if its sorted
        for(int i = 0 ; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }

        return true;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    /* ------------------------------------------------Method 2-------------------------------------------------------------------------------------*/
    //the idea is to do a inorder Traversal and keep the value of the previous node.
    //This is iterative inorder traversal
    public boolean isValidBST2 (TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        TreeNode cur = root ;
        TreeNode pre = null ;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left ;
            } else {
                TreeNode p = stack.pop() ;
                if (pre != null && p.val <= pre.val) {
                    return false ;
                }
                pre = p ;
                cur = p.right ;
            }
        }
        return true ;
    }

    /* ------------------------------------------------Method 3-------------------------------------------------------------------------------------*/
    //All values on the left sub tree must be less than root, and all values on the right sub tree must be greater than root. So we just check the boundaries for each node.
    //This solution also goes to the left subtree first. If the violation occurs close to the root but on the right subtree, the method still cost O(n)
    //T(n) = O(n)
    public boolean isValidBST3(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
