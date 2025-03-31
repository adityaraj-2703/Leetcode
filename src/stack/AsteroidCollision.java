package stack;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                while (!st.isEmpty() && st.peek() < 0 && (Math.abs(st.peek()) <= asteroids[i])) {
                    st.pop();

                }
                if (st.isEmpty()) {
                    st.push(asteroids[i]);
                } else if (Math.abs(st.peek()) == Math.abs(asteroids[i])) {
                    st.pop();
                } else if (!st.isEmpty() && st.peek() > 0) {
                    st.push(asteroids[i]);
                }
            } else {
                while (!st.isEmpty() && st.peek() > 0 && (st.peek() < Math.abs(asteroids[i]))) {

                    st.pop();

                }
                if (st.isEmpty()) {
                    st.push(asteroids[i]);
                } else if (Math.abs(st.peek()) == Math.abs(asteroids[i])) {
                    st.pop();
                } else if (!st.isEmpty() && st.peek() < 0) {
                    st.push(asteroids[i]);
                }

            }
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = { 8, -8 };
        AsteroidCollision a = new AsteroidCollision();
        int[] ans = a.asteroidCollision(asteroids);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

}
