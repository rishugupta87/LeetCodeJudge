package Trees.Q_01_Traversals;

import Trees.library.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    private static Queue<TreeNode> globalQueue = new LinkedList<TreeNode>();

    public void levelOrderTraversal(final TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root); //discovered TreeNode

        while(!queue.isEmpty()) {
            //add the left and right child of the discovered TreeNode to the queue
            TreeNode discovered = queue.remove(); //retrieve head of queue but do not remove it.
            if(discovered.left != null) queue.add(discovered.left);
            if(discovered.right != null) queue.add(discovered.right);
            System.out.println(discovered.data); //remove the head of the queue and print it
        }
    }

    public void levelOrderTraversal_Recursive(final TreeNode root) {
        if(root == null) return;

        if(!globalQueue.contains(root)) {
            globalQueue.add(root);
        }
        if(root.left != null) globalQueue.add(root.left);
        if(root.right != null) globalQueue.add(root.right);
        System.out.println(globalQueue.remove().data); //remove the head of the queue and print it
        levelOrderTraversal_Recursive(globalQueue.peek());
    }
}
