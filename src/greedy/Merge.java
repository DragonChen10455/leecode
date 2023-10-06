package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1;i < intervals.length;i++) {
            if(intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args){
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
