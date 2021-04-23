package simple;

import java.util.Deque;
import java.util.LinkedList;
import static java.lang.Math.*;

/**
 * @author Wapiti
 * @date 4/23
 */
public class MinStack {
    //元素栈
    Deque<Integer> xStack;
    //辅助栈
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        //辅助栈压栈一个极大值
        minStack.push(Integer.MAX_VALUE);
    }
    public void push(int x) {
        xStack.push(x);
        //当前最小值进入辅助栈
        minStack.push(Math.min(minStack.peek(), x));
    }
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
