package leetcode.to300;

import java.util.Stack;


public class _232_ImplementQueueusingStacks2 {


    Stack<Integer> s1;
    Stack<Integer> s2;


    public _232_ImplementQueueusingStacks2() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // time : O(n);

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }


    public int pop() {
        return s1.pop();
    }


    public int peek() {
        return s1.peek();
    }


    public boolean empty() {
        return s1.isEmpty();
    }
}
