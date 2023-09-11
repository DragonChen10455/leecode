package link.DesignLinkedList;

class MySinglyLinkedList {
    private SinglyListNode head;

    public MySinglyLinkedList() {
        this.head = null;
    }

    public int get(int index) {
        int i = 0;
        for(SinglyListNode node = this.head; node != null; node = node.next){
            if(i == index) {
                return node.val;
            }
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        this.head = new SinglyListNode(val, this.head);
    }

    public void addAtTail(int val) {
        if(this.head == null) {
            this.head = new SinglyListNode(val, null);
        }
        else {
            SinglyListNode node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new SinglyListNode(val, null);
        }
    }

    public void addAtIndex(int index, int val) {
        SinglyListNode preHead = new SinglyListNode(0, this.head);
        int i = 0;
        for(SinglyListNode preNode = preHead, node = this.head; preNode != null; preNode = node, node = node.next){
            if(i == index) {
                preNode.next = new SinglyListNode(val, node);
                if(index == 0) {
                    this.head = preHead.next;
                }
                return;
            }
            i++;
            if(node == null) {
                return;
            }
        }
    }

    public void deleteAtIndex(int index) {
        SinglyListNode preHead = new SinglyListNode(0, this.head);
        int i = 0;
        for(SinglyListNode preNode = preHead, node = this.head; node != null; preNode = node, node = node.next){
            if(i == index) {
                if(index == 0) {
                    this.head = head.next;
                    return;
                }
                preNode.next = node.next;
                return;
            }
            i++;
        }
    }
}
