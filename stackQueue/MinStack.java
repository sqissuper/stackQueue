package stackQueue;

import java.util.Stack;

class MinStack {

    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> ms = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    //放入元素
    public void push(int x) {
        s.push(x);
        if(ms.empty()) {
            ms.push(x);
        } else {
            if(x <= ms.peek()) {
                ms.push(x);
            }
        }
    }

    //删除栈顶元素
    public void pop() {
        int x = s.pop();
        if(x == ms.peek()) {
            ms.pop();
        }
    }

    //获得栈顶元素
    public int top() {
        return s.peek();
    }

    //获得最小值
    public int getMin() {
        return ms.peek();
    }
}