package com.jesse.stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class InBuiltExamples {
    public static void main(String[] args) {
//        Stack<Integer> stk = new Stack();
//        stk.push(34);
//        stk.push(45);
//        stk.push(2);
//        stk.push(9);
//        stk.push(18);
//
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());

//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(3);
//        queue.add(6);
//        queue.add(5);
//        queue.add(19);
//        queue.add(1);
//
////        System.out.println(queue.peek());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(89);
        deque.addLast(79);
        deque.removeFirst();
    }
}
