package zzz_everyday;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MonoStack {
    public static void main(String[] args){
        Deque<Integer> deque = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
//        deque.push(1);
//        deque.push(2);
        deque.addFirst(1);
        deque.addFirst(2);
        stack.push(1);
        stack.push(2);
        System.out.println(deque.peek());
        System.out.println(stack.peek());
    }
}
