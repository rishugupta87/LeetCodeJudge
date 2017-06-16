package Trees;

/**
 * Created by rg029761 on 1/17/17.
 */
public class Node {

    int val;
    Node left;
    Node right;
    Node parent; //optional

    Node(int x) {
        val = x;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
