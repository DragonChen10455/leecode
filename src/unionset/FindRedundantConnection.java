package unionset;

public class FindRedundantConnection {
    class UnionFind{
        public int[] parent;
        //初始化
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        //查找
        public int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        //合并节点
        public void union(int x, int y){
            if(find(x) == find(y)) return;
            parent[find(x)] = find(y);
        }
        //是否为同一父节点,也就是是否联通
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        UnionFind set = new UnionFind(edges.length);
        for (int[] edge: edges) {
            if(!set.isConnected(edge[0], edge[1])){
                set.union(edge[0], edge[1]);
            }
            else {
                ans = edge;
            }
        }
        return ans;
    }
}
