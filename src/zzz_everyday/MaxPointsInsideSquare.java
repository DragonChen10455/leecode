package zzz_everyday;

import java.util.*;

public class MaxPointsInsideSquare {
    public static int maxPointsInsideSquare(int[][] points, String s) {
        Map<Integer, List<Character>> map = new TreeMap<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int g = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            char c = s.charAt(i);
            List<Character> list;
            if (!map.containsKey(g)) {
                list = new ArrayList<>();
            } else {
                list = map.get(g);
            }
            list.add(c);
            map.put(g, list);
        }
        Set<Character> totalSet = new HashSet<>();
        for (int edge : map.keySet()) {
            List<Character> list = map.get(edge);
            Set<Character> curSet = new HashSet<>(list);
            if(curSet.size() == list.size() && totalSet.stream().noneMatch(curSet::contains)){
                totalSet.addAll(curSet);
            } else {
                break;
            }
        }
        return totalSet.size();
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {-2, -2}, {-2, 2}};
        System.out.println(maxPointsInsideSquare(points, "abb"));
    }
}
