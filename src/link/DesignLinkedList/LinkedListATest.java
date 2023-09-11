package link.DesignLinkedList;

public class LinkedListATest {
    public static void main(String[] args){
        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
        mySinglyLinkedList.addAtHead(1);
        mySinglyLinkedList.addAtTail(3);
        mySinglyLinkedList.addAtIndex(1, 2);
//        mySinglyLinkedList.addAtIndex(0, 20);
//        mySinglyLinkedList.addAtIndex(1, 30);
//        System.out.println(mySinglyLinkedList.get(1));
//        mySinglyLinkedList.deleteAtIndex(0);
        System.out.println(mySinglyLinkedList.get(1));
    }
}
