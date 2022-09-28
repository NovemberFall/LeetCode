package Stack.sortWithTwoStacks;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class sortWithTwoStacks {
    public void sort(LinkedList<Integer> s1) {
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<>();
        sort(s1, s2);
    }

    private void sort(Deque<Integer> input, Deque<Integer> buffer) {
        //Method 1:
        //input: unsorted elements
        //buffer: (top part) buffer, (bottom part) sorted elements
        //step 1: sort in ascending order and store result in buffer
        while (!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if (cur == curMin) {//注意这一步，如果cur == curMin,
                    count++;             //那么count就算有多少个当前最小元素
                }
                buffer.offerFirst(cur);//把所有input内的element 倒腾进 buffer
            }

            //buffer.peekFirst() >= curMin, 如果有之前的元素是比 curMin 小，那就不需要，
            //再倒腾回 input 里， 已经排好序的元素就留在buffer里， buffer[  |  1]
            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                int tmp = buffer.pollFirst();
                if (tmp != curMin) {
                    input.offerFirst(tmp);
                }
            }

            while (count > 0) {// 检测 globalMin_count 有多少个，是否有重复的当前最小元素
                buffer.offerFirst(curMin);//如果有，就把他们依次push进buffer
                count--;                //e.g. buffer[ | 1 1 1 1 1]
            }
        }

        //step 2: move result from buffer to input, so it's in descending order
        while (!buffer.isEmpty()) {
            input.offerFirst(buffer.pollFirst());
        }

    }

    public static void main(String[] args) {
        sortWithTwoStacks swts = new sortWithTwoStacks();
        LinkedList<Integer> temp = new LinkedList<>(Arrays.asList(1, 9, 5, 6, 3, 2));
        swts.sort(temp);
        System.out.println(temp);
    }
}