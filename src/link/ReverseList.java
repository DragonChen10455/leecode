package link;

import link.DesignLinkedList.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println(reverseList(head).val);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
//    public static ListNode reverseList(ListNode head) {
//        return reverse(null, head);
//    }
//
//    private static ListNode reverse(ListNode prev, ListNode cur) {
//        if (cur == null) {
//            return prev;
//        }
//        ListNode temp = null;
//        temp = cur.next;// 先保存下一个节点
//        cur.next = prev;// 反转
//        // 更新prev、cur位置
//        // prev = cur;
//        // cur = temp;
//        return reverse(cur, temp);
//    }

//    ListNode static reverseList(ListNode head) {
//        // 边缘条件判断
//        if(head == null) return null;
//        if (head.next == null) return head;
//
//        // 递归调用，翻转第二个节点开始往后的链表
//        ListNode last = reverseList(head.next);
//        // 翻转头节点与第二个节点的指向
//        head.next.next = head;
//        // 此时的 head 节点为尾节点，next 需要指向 NULL
//        head.next = null;
//        return last;
//    }
}
