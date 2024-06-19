package zzz_everyday;

import java.util.*;

public class MaxIncreasingCells {
    public static int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        TreeMap<Integer, List<int[]>> mp = new TreeMap<>();
        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                mp.putIfAbsent(mat[i][j], new ArrayList<>());
                mp.get(mat[i][j]).add(new int[]{i, j});
            }
        }

        List<Integer> keys = new ArrayList<>(mp.keySet());

        for (int key : keys) {
            List<int[]> pos = mp.get(key);
            List<Integer> res = new ArrayList<>();
            // arr[0]横坐标 arr[1]纵坐标
            for (int[] arr : pos) {
                res.add(Math.max(row[arr[0]], col[arr[1]]) + 1);
            }
            for (int i = 0; i < pos.size(); i++) {
                int[] arr = pos.get(i);
                int d = res.get(i);
                row[arr[0]] = Math.max(row[arr[0]], d);
                col[arr[1]] = Math.max(col[arr[1]], d);
            }
        }
        return Arrays.stream(row).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] mat = {{3,1,6},{-9,5,7}};
        System.out.println(maxIncreasingCells(mat));
    }
}
