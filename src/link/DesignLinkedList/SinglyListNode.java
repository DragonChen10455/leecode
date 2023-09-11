package link.DesignLinkedList;

public class SinglyListNode {
    int val;
    SinglyListNode next;

    SinglyListNode(){

    }

    SinglyListNode(int val) { this.val = val; }

    public SinglyListNode(int val, SinglyListNode next){
        this.val = val;
        this.next = next;
    }
}
