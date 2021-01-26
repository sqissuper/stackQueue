package stackQueue;

import java.util.Stack;

public class MyQueue {
    /** Initialize your data structure here. */
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) return -1;
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if(s2.empty()) return -1;
        return s2.pop();

    }

    /** Get the front element. */
    public int peek() {
        if(empty()) return -1;
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if(s2.empty()) return -1;
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
