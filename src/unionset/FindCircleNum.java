package unionset;

import template.UnionFind;

public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        UnionFind set = new UnionFind(isConnected.length);
        for(int i = 0;i < isConnected.length;i++){
            for (int j = 0; j < isConnected[0].length; j++) {
                if(isConnected[i][j] == 1){
                    set.union(i, j);
                }
            }
        }
        return set.count;
    }
}
