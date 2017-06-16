package Trees.Q_01_Traversals;

import Trees.library.BinarySearchTree;
import Trees.library.TreeNode;

import java.util.Stack;

/**
 * Created by rg029761 on 5/18/17.
 */
public class PostOrderTraversal {

    public static void postorder(TreeNode root) {
        if(root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    //need to use two stacks for this.
    // 1.push root on stack1
    // 2. - pop node from stack1  and push in stack2
    //    - push node left and right child to stack1
    //    - keep repeating 2
    // 3. print s2 while popping elements
    public static void postorder_iterative(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);

        while(!s1.isEmpty()) {
            TreeNode n = s1.pop();
            s2.push(n);
            if(n.left != null) {
                s1.push(n.left);
            }
            if(n.right != null) {
                s1.push(n.right);
            }
        }

        while(!s2.isEmpty()) {
            System.out.println(s2.pop().data);
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
        bst2.add(90);
        bst2.add(100);

        PostOrderTraversal.postorder_iterative(bst2.root);
    }
}
