package greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) ->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[people.length][]);
    }
}
