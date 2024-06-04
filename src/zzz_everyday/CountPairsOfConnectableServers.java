package zzz_everyday;

import java.util.*;

public class CountPairsOfConnectableServers {

    public static int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            int pre = 0;
            for(int[] e : graph[i]){
                int cnt = dfs(e[0], i, e[1] % signalSpeed, signalSpeed, graph);
                res[i] += pre * cnt;
                pre += cnt;
            }
        }
        return res;
    }

    public static int dfs(int near, int pass, int curr, int signalSpeed, List<int[]>[] graph){
        int res = 0;
        if(curr == 0){
            res++;
        }
        for(int[] e : graph[near]){
            int u = e[0];
            int weight = e[1];
            if(u != pass){
                res += dfs(u, near, (curr + weight) % signalSpeed, signalSpeed, graph);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 6, 3}, {6, 5, 3}, {0, 3, 1}, {3, 2, 7}, {3, 1, 6}, {3, 4, 2}};
        System.out.println(Arrays.toString(countPairsOfConnectableServers(edges, 1)));
    }
}
