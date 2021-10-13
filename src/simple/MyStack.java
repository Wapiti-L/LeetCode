package simple;

import java.util.LinkedList;
import java.util.Queue;

//队列实现栈
public class MyStack {
    Queue<Integer> queue;
    //Initialize stack
    public MyStack(){
        queue  = new LinkedList<Integer>();
    }

    //Push
    public void push(int x){
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i ++){
            queue.offer(queue.poll());//所有元素出队再入队
        }
    }

    //Remove element
    public int pop(){
        return queue.poll();
    }

    //get the top
    public int top(){
        return queue.peek();
    }

    //whether the stack is empty
    public boolean empty(){
        return queue.isEmpty();
    }

}
