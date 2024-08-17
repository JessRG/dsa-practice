package com.jesse.stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class Questions {
    public static void main(String[] args) throws Exception {
        // Implement Queue Using Stacks
//        QueueUsingStack stk = new QueueUsingStack();
//        for (int i = 0; i < 5; i++) {
//            stk.add(i + 1);
//        }
//        System.out.println(stk.peek());
//        System.out.println(stk.remove());
//
//        QueueUsingStackRemove stkR = new QueueUsingStackRemove();
//        for (int i = 0; i < 5; i++) {
//            stkR.add(i + (1*10) + 1);
//        }
//        System.out.println(stkR.peek());
//        System.out.println(stkR.remove());

//        int[] a = new int[] { 4, 2, 4, 6, 1 };
//        int[] b = new int[] { 2, 1, 8, 5 };


        // Game of Two Stacks
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = s.nextInt();
//            int m = s.nextInt();
//            int x = s.nextInt();
//            int[] a = new int[n];
//            int[] b = new int[m];
//            for (int j = 0; j < n; j++) {
//                a[j] = s.nextInt();
//            }
//            for (int j = 0; j < m; j++) {
//                b[j] = s.nextInt();
//            }
//            System.out.println(TwoStacks.twoStacks(x, a, b));
//        }

        String s = "))())(";
        Parentheses pth = new Parentheses();
        System.out.println(pth.minInsertions(s));
    }
}

class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        first.push(item);
    }

    public int remove() throws Exception {
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() throws Exception {
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked = second.peek();
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }
}

class QueueUsingStackRemove {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStackRemove() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) throws Exception {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        first.push(item);
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove() throws Exception {
       return first.pop();
    }

    public int peek() throws Exception {
        return first.peek();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }
}

// Game of Two Stacks
class TwoStacks {
    static int twoStacks(int x, int[] a, int[] b) {
        return twoStacks(x, a, b, 0, 0) - 1;
    }

    private static int twoStacks(int x, int[] a, int[] b, int sum, int count) {
        if (sum > x) {
            return count;
        }

        if (a.length == 0 || b.length == 0) {
            return count;
        }

        int ans1 = twoStacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
        int ans2 = twoStacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);

        return Math.max(ans1, ans2);
    }
}

class LargestAreaHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while(!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private static int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();
        if (stack.isEmpty()) {
            area = arr[popped] * i;
        } else {
            area = arr[popped] * (i - 1 - stack.peek());
        }

        return Math.max(max, area);
    }
}

class Parentheses {
    public Parentheses() {}

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (s.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (s.charAt(i) == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if (s.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }

    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (i+1 < s.length() && s.charAt(i+1) == ')') {
                    i++;
                } else {
                    insertions++;
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    insertions++;
                }
            }
        }

        return insertions + stack.size() * 2;
    }
}
