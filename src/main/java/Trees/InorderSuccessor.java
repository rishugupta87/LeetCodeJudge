//package Trees;
//
///**
// * Created by rg029761 on 1/17/17.
// */
//public class InorderSuccessor {
//
//    /**
//     * Find inorder successor if the parent link is provided.
//     *
//     * T(n) = O(n) Space is O(n)
//     *
//     * @param data
//     * @param root
//     * @return
//     */
//    public static Node getInorderSuccessor_withParentLink(int data, final Node root) {
//        //first search for this node in the binary tree.
//       // Node currNode = BinarySearchTree.search(root, data);
//        TreeN currNode ;
//
//
//        //Case 1 : If the x has a right child then
//        // its inorder successor will the left most element in the right sub tree of x.
//        if(currNode.right != null) {
//            Node tmp = currNode.right;
//            while (tmp.left != null) {
//                tmp = tmp.left;
//            }
//            return tmp;
//        } else if(currNode.right == null){ //Case 2: If the x doesnt have a right child then its inorder successor will the one of its ancestors,
//            // using parent link keep traveling up till you get the node which is the left child of its parent.
//            // Then this parent node will be the inorder successor.
//            while(currNode.parent != null && currNode.parent.left != currNode) {
//                currNode = currNode.parent;
//            }
//            return currNode.parent;
//        }
//
//        //Case 3: if x is the right most node in the tree then its inorder successor will be NULL.
//        return null;
//    }
//
//    /**
//     * The idea is to compare root's value with p's value if root is not null, and consider the following two cases:
//
//       root.val > p.val. In this case, root can be a possible answer, so we store the root node first and
//       call it res. However, we don't know if there is anymore node on root's left that is larger than p.val.
//       So we move root to its left and check again.
//
//       root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's left child.
//       So we only need to consider root's right child, thus we move root to its right and check again.
//
//       We continuously move root until exhausted. To this point, we only need to return the res in case 1.
//     *
//     * @param root
//     * @param p
//     * @return
//     */
//    public static TreeNode inorderSuccessor_WithoutParentLink(TreeNode root, TreeNode p) {
//        TreeNode res = null;
//        while(root!=null) {
//            if(root.val > p.val) {
//                res = root;
//                root = root.left;
//            }
//            else root = root.right;
//        }
//        return res;
//    }
//}
