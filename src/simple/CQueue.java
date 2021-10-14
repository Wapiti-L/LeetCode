package simple;

import java.util.LinkedList;

/**
 * @author Wapiti
 * @date 10/14
 */
public class CQueue {
    LinkedList<Integer> A,B;
    public CQueue(){
        //A为添加栈，B为删除栈
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    //添加元素
    public void appendTail(int value){
        //栈顶插入即可
        A.addLast(value);
    }
    //删除元素
    public int deleteHead(){
        //b不空 直接返回栈顶
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        //b空 判断a是否为空 全空返回-1
        if (A.isEmpty()) {
            return -1;
        }
        //b空a不空 全部入b栈
        while (!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
