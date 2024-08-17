package com.jesse.stacksAndQueues;

public class StackMain {
    public static void main(String[] args) throws StackException {
        CustomStack stk = new DynamicStack(5);
        stk.push(34);
        stk.push(45);
        stk.push(2);
        stk.push(9);
        stk.push(18);
        stk.push(89);



        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
