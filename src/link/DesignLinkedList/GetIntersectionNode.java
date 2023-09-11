package link.DesignLinkedList;

public class GetIntersectionNode {
    public static void main(String[] args){
        ListNode a5 = new ListNode(5,null);
        ListNode a4 = new ListNode(4,a5);
        ListNode a3 = new ListNode(8,a4);
        ListNode a2 = new ListNode(1,a3);
        ListNode headA1 = new ListNode(4,a2);

        ListNode b3 = new ListNode(1,a3);
        ListNode b2 = new ListNode(0,b3);
        ListNode headB1 = new ListNode(5,b2);

        ListNode head = getIntersectionNode(headA1, headB1);
        System.out.println(head.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 取出较长的那一个链表，取为curA，长度为lenA
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
