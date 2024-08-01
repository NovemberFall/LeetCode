package phone_OA_OnSite.TikTok;

import java.util.Stack;

class _735_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int diff = a + stack.peek();
                if (diff < 0) {
                    stack.pop();
                } else if (diff > 0) {
                    a = 0;
                } else {
                    stack.pop();
                    a = 0;
                }
            }

            if (a != 0) {
                stack.push(a);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
