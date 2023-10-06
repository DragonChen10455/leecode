package greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for(int i = 0;i < chars.length;i++) {
            edge[chars[i] - 'a'] = i;
        }

        int idx = 0;
        int last = -1;
        for(int i = 0;i < chars.length;i++) {
            idx = Math.max(idx, edge[chars[i] - 'a']);
            if(idx == i) {
                list.add(i - last);
                last = i;
            }
        }

        return list;
    }
}
