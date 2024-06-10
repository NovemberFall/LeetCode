package Self_Training.Stack;


import Self_Training.ListNode;
import org.testng.annotations.Test;


/**
    - Use "head" as "head"

    2 -> null   1 -> null
                head
    prev

    因为stack 只是一头进，所以不需要 tail
 */
class MyStack_EmptyVersion {
    private ListNode head;

    public Integer pop() {

        return null;
    }

    public Integer peek() {

        return null;
    }

    public void push(int e) {

    }

    @Test
    void testPop() {
        MyStack_EmptyVersion stack = new MyStack_EmptyVersion();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        int pop = stack.pop();
        System.out.println(pop);// 5
    }

    @Test
    void testPush() {
        MyStack_EmptyVersion stack = new MyStack_EmptyVersion();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.peek());// 5
    }
}
