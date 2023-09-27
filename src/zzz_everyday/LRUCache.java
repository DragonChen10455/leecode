package zzz_everyday;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Node dummy = new Node(0, 0); // 哨兵节点
    private Map<Integer, Node> keyNodeMap = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dummy.pre = this.dummy;
        this.dummy.next = this.dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null) {
            node.value = value;
        } else {
            node = new Node(key, value);
            keyNodeMap.put(key, node);
            pushFront(node);
            if(this.keyNodeMap.size() > this.capacity) {
                keyNodeMap.remove(this.dummy.pre.key);
                remove(this.dummy.pre);
            }
        }
    }

    private Node getNode(int key){
        if(!this.keyNodeMap.containsKey(key)) return null;
        Node node = this.keyNodeMap.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    private void pushFront(Node n){
        n.pre = this.dummy;
        n.next = this.dummy.next;
        n.pre.next = n;
        n.next.pre = n;
    }
}
