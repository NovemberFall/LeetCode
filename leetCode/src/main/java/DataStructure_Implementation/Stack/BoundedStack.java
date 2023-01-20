package DataStructure_Implementation.Stack;

class BoundedStack {
    int[] array;
    int head;

    public BoundedStack(int cap) {
        // check cap
        if (cap < 1) {
            throw new IllegalArgumentException("Capacity must be 1 or more");
        }
        array = new int[cap];
        head = -1;
    }

    public boolean push(int ele) {
        if (head == array.length - 1) {
            return false;
        }
        array[++head] = ele;
        return true;
    }

    public Integer pop() {
        return head == -1 ? null : array[head--];
    }

    public Integer top() {
        return head == -1 ? null : array[head];
    }

    public static void main(String[] args) {
        BoundedStack boundedStack = new BoundedStack(5);
        boundedStack.push(2);
        boundedStack.push(5);
        boundedStack.push(1);
        boundedStack.push(7);
        boundedStack.push(9);
        System.out.println(boundedStack.top()); // 9
        System.out.println(boundedStack.pop()); // 9
    }
}
