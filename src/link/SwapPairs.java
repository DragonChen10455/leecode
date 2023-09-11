package link;

import link.DesignLinkedList.ListNode;

public class SwapPairs {
    public static void main(String[] args){
        ListNode node3 = new ListNode(4, null);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        head = swapPairs(head);
        System.out.println(head.val);
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        else {
            ListNode prehead = new ListNode(0, head);
            ListNode pre = prehead, node = head, nex = head.next;
            while(nex != null) {
                pre.next = nex;
                node.next = nex.next;
                nex.next = node;

                head = prehead.next;

                pre = node;
                node = pre.next;
                if(pre.next == null){
                    return head;
                }
                else {
                    nex = pre.next.next;
                }
            }
            return head;
        }
    }
}
