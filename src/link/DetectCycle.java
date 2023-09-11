package link;

import link.DesignLinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    public static void main(String[] args){
        ListNode head = new ListNode(1, null);
        System.out.println(detectCycle(head));
    }

//    public static ListNode detectCycle(ListNode head){
//        ListNode fast = head;
//        ListNode slow = head;
//        while(fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            // 快慢指针相遇，此时从head 和 相遇点，同时查找直至相遇
//            if (slow == fast) {
//                ListNode index1 = fast;
//                ListNode index2 = head;
//                while (index1 != index2) {
//                    index1 = index1.next;
//                    index2 = index2.next;
//                }
//                return index2; // 返回环的入口
//            }
//        }
//        return null;
//    }

    public static ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
