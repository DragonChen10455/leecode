package zzz_everyday;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    private final Deque<int[]> stack = new ArrayDeque<>();
    private int curDay = -1;

    public StockSpanner() {
        // {天数，价格}
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        while(price >= stack.peek()[1]) {
            stack.pop();
        }
        int ans = ++curDay - stack.peek()[0];
        stack.push(new int[]{curDay, price});
        return ans;
    }
}
