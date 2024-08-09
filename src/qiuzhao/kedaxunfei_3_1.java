package qiuzhao;

import java.util.*;

public class kedaxunfei_3_1 {
    static class TreeNode{
        int id;
        int value;
        List<TreeNode> children;

        TreeNode(int id, int value){
            this.id = id;
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
    static int rec = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n + 1];
        for(int i = 1;i <= n;i++){
            values[i] = in.nextInt();
        }
        TreeNode[] nodes = new TreeNode[n+1];
        for(int i = 1;i <= n;i++){
            nodes[i] = new TreeNode(i, values[i-1]);
        }
        for(int i = 0;i < n-1;i++){
            int fa = in.nextInt();
            int ch = in.nextInt();
            nodes[fa].children.add(nodes[ch]);
        }
        int ans1 = 0;
        int ans2 = 0;

        List<Integer> res = new ArrayList<>();
        for(TreeNode child : nodes[1].children){
            dfs(child, 0);
            res.add(rec);
            rec = 0;
        }
        Collections.sort(res);
        if(res.size() > 1){
            ans1 = res.get(res.size() - 1) + 1 + res.get(res.size() - 2);
        } else {
            ans1 = res.get(0);
        }

        for(TreeNode child : nodes[1].children){
            dfs(child, 1);
            res.add(rec);
            rec = 0;
        }
        Collections.sort(res);
        if(res.size() > 1){
            ans2 = res.get(res.size() - 1) + 1 + res.get(res.size() - 2);
        } else {
            ans2 = res.get(0);
        }
        System.out.println(Math.max(ans1, ans2));
    }

    private static int dfs(TreeNode node, int flag){
        if(node == null) return 0;
        int maxChain = 1;
        for(TreeNode child : node.children){
            int childLength = dfs(child, flag);
            if(flag == 0 && node.value <= child.value){
                maxChain = Math.max(maxChain, childLength + 1);
            } else if(flag == 1 && node.value >= child.value){
                maxChain = Math.max(maxChain, childLength + 1);
            }
        }
        rec = Math.max(rec, maxChain);
        return maxChain;
    }
}