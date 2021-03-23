import java.util.Stack;

/**
 * @description:
 * @author: zww
 * @date: 2021/3/5
 * @version: V1.0
 */
public class MyQueue {
    Stack<Integer> out;
    Stack<Integer> in;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.out = new Stack<>();
        this.in = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return out.isEmpty()&&in.isEmpty();
    }
}
