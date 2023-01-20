package Self_Training.Stack;

class BoundedStack_EmptyVersion {
    int[] array;
    int head;

    public BoundedStack_EmptyVersion(int cap) {

    }

    public boolean push(int ele) {

        return true;
    }

    public Integer pop() {
        return null;
    }

    public Integer top() {
        return null;
    }

    public static void main(String[] args) {
        BoundedStack_EmptyVersion boundedStack = new BoundedStack_EmptyVersion(5);
        boundedStack.push(2);
        boundedStack.push(5);
        boundedStack.push(1);
        boundedStack.push(7);
        boundedStack.push(9);
        System.out.println(boundedStack.top()); // 9
        System.out.println(boundedStack.pop()); // 9
    }
}
