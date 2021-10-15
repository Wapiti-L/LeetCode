package simple;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import static java.lang.Math.*;

/**
 * @author Wapiti
 * @date 4/23
 */
public class MinStack {
    //元素栈
    Stack<Integer> xStack;
    //辅助栈
    Stack<Integer> minStack;

    public MinStack() {
        xStack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x) {
        xStack.push(x);
        //当前最小值进入辅助栈
        if (minStack.isEmpty() || x < minStack.peek()) {

            minStack.push(x);
        }
    }
    public void pop() {
        //当出栈元素恰好为最小元素时，同时出栈
        if (xStack.pop().equals(minStack.peek())){
            minStack.pop();
        }
        System.out.println(xStack.peek()+minStack.peek());
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
