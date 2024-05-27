package template;

public class UnionFind{
    public int[] parent;
    public int count;
    //初始化
    public UnionFind(int n){
        parent = new int[n];
        count = n;
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
        count--;
    }
    //是否为同一父节点,也就是是否联通
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    //返回数量
    public int getCount(){
        return count;
    }
}
