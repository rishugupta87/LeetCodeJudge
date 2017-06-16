package Trees.Q_08_ConstructBinaryTree;

import Trees.library.TreeNode;

/**
 * Created by rg029761 on 5/21/17.
 */
public class ConstructBinaryTreeInorderPostorder {

    /**
     * The the basic idea is to take the last element in postorder array as the root, find the position of the root in the inorder array; then locate
     * the range for left sub-tree and right sub-tree and do recursion. Use a HashMap to record the index of root in the inorder array.
     *
     * @param inOrder
     * @param preorder
     * @return
     */
    public static TreeNode constructTree(int[] inOrder, int[] postorder) {
        return constructTreeFromInOrderAndPostOrder(inOrder, 0, inOrder.length-1, postorder, 0, postorder.length-1);
    }

    private static TreeNode constructTreeFromInOrderAndPostOrder(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if(inStart > inEnd  || postStart > postEnd){
            return null;
        }

        int rootData = postOrder[postEnd];
        TreeNode node = new TreeNode(rootData);

        int index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if(postOrder[postEnd]==inOrder[i]){
                index = i;
                break;
            }
        }

        int numberOfNodes = index - inStart;

        node.left = constructTreeFromInOrderAndPostOrder(inOrder, inStart, index-1, postOrder, postStart, (postStart + numberOfNodes)-1);
        node.right = constructTreeFromInOrderAndPostOrder(inOrder, index+1, inEnd, postOrder, postStart + numberOfNodes, postEnd-1);

        return node;
    }
}
