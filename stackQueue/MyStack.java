package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    /** Initialize your data structure here. */
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!q1.isEmpty()) {
            q1.offer(x);
        } else if(!q2.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }
        if(!q1.isEmpty()) {
            int size = q1.size();
            for(int i = 0; i < size - 1; i++) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else {
            int size = q2.size();
            for(int i = 0; i < size - 1; i++) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        int cur = -1;
        if(!q1.isEmpty()) {
            int size = q1.size();
            for(int i = 0; i < size; i++) {
                cur = q1.poll();
                q2.offer(cur);
            }
            return cur;
        } else {
            int size = q2.size();
            for(int i = 0; i < size; i++) {
                cur = q2.poll();
                q1.offer(cur);
            }
            return cur;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}