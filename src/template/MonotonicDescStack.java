package template;

import java.util.*;

public class MonotonicDescStack {
    // 栈头到栈底降序
    public int largestRectangleArea(int[] heights) {
        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;

        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        int res = 0;
        for(int i = 1;i < heights.length;i++) {
            if(heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if(heights[i] == heights[st.peek()]) {
                st.pop();
                st.push(i);
            } else {
                while(heights[i] < heights[st.peek()]) {
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int he = heights[mid];
                    int s = i - left - 1;
                    res = Math.max(res, he * s);
                }
                st.push(i);
            }
        }
        return res;
    }
}
