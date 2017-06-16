package Trees.Q_08_ConstructBinaryTree;

import Trees.library.TreeNode;

public class ConstructBinaryTreePreorderInorder {

    public static TreeNode constructTree(int[] inOrder, int[] preorder) {
        return constructTreeFromInOrderAndPreOrder(inOrder, 0, inOrder.length-1, preorder, 0, preorder.length-1);
    }

    private static TreeNode constructTreeFromInOrderAndPreOrder(int[] inOrder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if(inStart > inEnd  || preStart > preEnd){
            return null;
        }
        int rootData = preorder[preStart];
        TreeNode node = new TreeNode(rootData);

        int index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if(rootData == inOrder[i]){
                index = i;
                break;
            }
        }
        int numberOfNodes = index - inStart;

        node.left = constructTreeFromInOrderAndPreOrder(inOrder, inStart, index-1, preorder, preStart + 1, preStart + numberOfNodes);
        node.right = constructTreeFromInOrderAndPreOrder(inOrder, index+1, inEnd, preorder, preStart + numberOfNodes + 1, preEnd);

        return node;
    }
}
