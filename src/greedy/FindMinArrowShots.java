package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > points[i-1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            }
        }
        return count;
    }
}
