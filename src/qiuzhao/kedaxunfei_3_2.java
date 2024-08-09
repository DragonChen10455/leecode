package qiuzhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


//给出n个点的树，节点编号为1到n，根节点为1，每个节点i有一个权值ai。
//我们想在这棵树上找一条最长的链，使得这个链上的节点i均满足afa¡≤ai或者均满足ai≤afai，其中fai表示i的父亲节点，我们假定fa1=1。
//输出这个最长链的节点数。

/*
5
1 3 3 2 4
1 2
2 3
3 4
3 5

4
*/

/*
5
1 2 3 4 5
1 2
2 3
1 4
4 5

5
*/


class Link {
    public int less1;
    public int less2;
    public int greater1;
    public int greater2;

    public Link() {
        less1 = greater1 = 0;
        less2 = greater2 = 0;
    }
}

public class kedaxunfei_3_2 {
    private static int ans = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; ++i)
        {
            a[i] = scanner.nextInt();
        }
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 1; i < n; ++i)
        {
            int u = scanner.nextInt(), v = scanner.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        postorderTraversal(1, 0, g, a);
        System.out.println(ans);
    }

    private static Link postorderTraversal(int x, int fa, ArrayList<Integer>[] g, int[] a)
    {
        Link res = new Link();

        if (g[x].size() == 1 && g[x].get(0) == fa)
        {
            res.less1 = res.greater1 = res.less2 = res.greater2 = 0;
            return res;
        }

        for (int y : g[x]) {
            if (y == fa)
                continue;

            Link link = postorderTraversal(y, x, g, a);
            if (a[y] >= a[x])
            {
                if (link.less1 + 1 >= res.less1)
                {
                    res.less2 = res.less1;
                    res.less1 = link.less1 + 1;
                }
                else if (link.less1 + 1 > res.less2)
                {
                    res.less2 = link.less1 + 1;
                }
            }
            if (a[y] <= a[x])
            {
                if (link.greater1 + 1 >= res.greater1)
                {
                    res.greater2 = res.greater1;
                    res.greater1 = link.greater1 + 1;
                }
                else if (link.greater1 + 1 > res.greater2)
                {
                    res.greater2 = link.greater1 + 1;
                }
            }
        }
        updateAns(x, res);
        return res;
    }

    private static void updateAns(int x, Link link)
    {
        if (x == 1) {
            ans = Math.max(ans, link.less1 + link.less2 + 1);
        }
        else {
            ans = Math.max(ans, Math.max(link.less1 + link.less2, link.greater1 + link.greater2) + 1);
        }
    }
}
