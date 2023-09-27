package zzz_everyday;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private static class Node{
        int key;
        int value;
        Node pre;
        Node next;
        int freq = 1;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Map<Integer, Node> keyNodeMap;
    private Map<Integer, Node> freqNodeMap; // 存每个访问次数对应的哨兵节点
    private int min;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyNodeMap = new HashMap<>();
        this.freqNodeMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null) {
            node.value = value;
            return;
        }
        if(this.keyNodeMap.size() == this.capacity) {
            Node dummy = this.freqNodeMap.get(min);
            Node nodeToRemove = dummy.pre;
            this.keyNodeMap.remove(nodeToRemove.key);
            remove(nodeToRemove);
            if(dummy.pre == dummy) {
                this.freqNodeMap.remove(min);
            }
        }
        node = new Node(key, value);
        keyNodeMap.put(key, node);
        pushFront(1, node);
        min = 1;
    }

    private Node getNode(int key){
        if(!this.keyNodeMap.containsKey(key)) {
            return null;
        }
        Node node = this.keyNodeMap.get(key);
        remove(node);
        Node dummy = this.freqNodeMap.get(node.freq);
        if(dummy.pre == dummy) {
            this.freqNodeMap.remove(node.freq);
            // 访问次数最小的双链表被剔除了，访问次数最小列表需要加1
            if(this.min == node.freq) {
                this.min++;
            }
        }
        pushFront(++node.freq, node);
        return node;
    }

    private Node newList() {
        Node dummy = new Node(0, 0); // 哨兵节点
        dummy.pre = dummy;
        dummy.next = dummy;
        return dummy;
    }

    private void remove(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    private void pushFront(int freq, Node n) {
        Node dummy = this.freqNodeMap.computeIfAbsent(freq, k -> newList());
        n.pre = dummy;
        n.next = dummy.next;
        n.pre.next = n;
        n.next.pre = n;
    }
}
