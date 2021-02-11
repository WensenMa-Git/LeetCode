package to300;

import java.util.Stack;


public class _232_ImplementQueueusingStacks {


    Stack<Integer> s1;
    Stack<Integer> s2;

    public _232_ImplementQueueusingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }


    public void push(int x) {
        s1.push(x);
    }

    // time : O(n);

    public int pop() {
        if (!s2.isEmpty()) return s2.pop();
        else {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.pop();
        }
    }

    // time : O(n);

    public int peek() {
        if (!s2.isEmpty()) return s2.peek();
        else {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.peek();
        }
    }


    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}