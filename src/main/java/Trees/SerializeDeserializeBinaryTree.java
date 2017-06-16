package Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    /**
     * The idea is simple: print the tree in pre-order traversal and use "X" to
     * denote null node and split node with ",". We can use a StringBuilder for building
     * the string on the fly.
     *
     * For ex in https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
     * the tree will be serialized to [1,2,X,X,3,4,X,X,5,X,X,]
     *
     * @param root
     * @return
     */
    public static String serialize(final TreeNode root) {
        if(root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    /**
     * we use a Queue to store the pre-order traversal and since we have "X" as null node, we know exactly how to where to end building subtress.
     * queue is also used since we wanna take the first elememt out.
     *
     * @param serializedString
     * @return
     */
    public static TreeNode deserialize(final String serializedString) {
        if(serializedString == null) {
            return null;
        }
        String[] splitString = serializedString.split(",");
        Queue<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(splitString));


        return buildTree(nodes);
    }

    private static TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if(val.equals("X")) {
            return null;
        }
        TreeNode n = new TreeNode(Integer.valueOf(val));
        n.left = buildTree(nodes);
        n.right = buildTree(nodes);
        return n;
    }


    private static void buildString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("X").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serializedString = serialize(root);
        System.out.println(serializedString); //1,2,X,X,3,4,X,X,5,X,X,
        TreeNode n = deserialize(serializedString);
        BinaryTreePrinter.printNode(n);
    }
}
