package link;

import link.DesignLinkedList.ListNode;

public class RemoveNthFromEnd {
    public static void main(String[] args){
        ListNode node4 = new ListNode(5, null);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        head = removeNthFromEnd(head, 2);
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0, head);
        ListNode node = head, end = head;
        ListNode pre = preHead;
        if(head == null) {
            return null;
        }
        int i = 1;
        while(i < n) {
            end = end.next;
            i++;
        }
        while(end.next != null){
            node = node.next;
            pre = pre.next;
            end = end.next;
        }
        pre.next = node.next;
        if(node == head) {
            return pre.next;
        }
        return head;
    }
}
