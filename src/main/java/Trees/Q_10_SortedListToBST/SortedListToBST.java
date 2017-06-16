package Trees.Q_10_SortedListToBST;

import Trees.library.TreeNode;

/**
 * Created by rg029761 on 5/21/17.
 */
public class SortedListToBST {

    /**
     1) Get the Middle of the linked list and make it root.
     2) Recursively do same for left half and right half.
        a) Get the middle of left half and make it left child of the root
       created in step 1.
       b) Get the middle of right half and make it right child of the
       root created in step 1.
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;

        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;


        while(fast!=tail && fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }

    class ListNode {
        ListNode next;
        int val;
    }
}
