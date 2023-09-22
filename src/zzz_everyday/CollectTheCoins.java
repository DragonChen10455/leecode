package zzz_everyday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectTheCoins {
    public static class Node{
        private Set<Integer> neighbour;
        private int edge;

        public Set<Integer> getNeighbour() {
            return neighbour;
        }

        public void setNeighbour(Set<Integer> neighbour) {
            this.neighbour = neighbour;
        }

        public int getEdge() {
            return edge;
        }

        public void setEdge(int edge) {
            this.edge = edge;
        }
    }

    public static int collectTheCoins(int[] coins, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < edges.length; i++) {
            int key1 = edges[i][0];
            if(!graph.containsKey(key1)) {
                Node node = new Node();
                Set<Integer> neighbour = new HashSet<>();
                neighbour.add(edges[i][1]);
                node.setEdge(1);
                node.setNeighbour(neighbour);
                graph.put(key1, node);
            } else {
                Node node = graph.get(key1);
                node.getNeighbour().add(edges[i][1]);
                node.setEdge(node.getEdge() + 1);
            }

            int key2 = edges[i][1];
            if(!graph.containsKey(key2)) {
                Node node = new Node();
                Set<Integer> neighbour = new HashSet<>();
                neighbour.add(edges[i][0]);
                node.setEdge(1);
                node.setNeighbour(neighbour);
                graph.put(key2, node);
            } else {
                Node node = graph.get(key2);
                node.getNeighbour().add(edges[i][0]);
                node.setEdge(node.getEdge() + 1);
            }
        }

        minus(graph);
        minus(graph);

        for (int key : graph.keySet()) {
            if(graph.get(key).getEdge() >= 1) {
                ans++;
            }
        }

        return ans;
    }

    public static void minus(Map<Integer, Node> graph){
        Set<Integer> keyMinusSet = new HashSet<>();
        for (int key : graph.keySet()) {
            Node node = graph.get(key);
            if(node.getEdge() == 1) {
                keyMinusSet.add(key);
            }
        }

        for (int key : graph.keySet()) {
            for (int minusKey : keyMinusSet) {
                if(key == minusKey || graph.get(key).getNeighbour().contains(minusKey)) {
                    Node node = graph.get(key);
                    node.setEdge(node.getEdge()-1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] coins = {1,0,0,0,0,1};
        int[][] edges = {{0,1}, {1,2}, {2,3}, {3,4}, {4,5}};
        System.out.println(collectTheCoins(coins, edges));
    }
}
