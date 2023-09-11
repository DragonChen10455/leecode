package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RetrieveBD {
    private int n;
    private int[][] maze;
    private int[] visited;

    public RetrieveBD(int n, int[][] maze, int[] visited) {
        this.n = n;
        this.maze = maze;
        this.visited = visited;
    }

    public void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        this.visited[start] = 1;
        while (!q.isEmpty()) {
            int front = q.peek();
            System.out.print(front + " ");
            q.poll();
            for (int i = 1; i <= this.n; i++) {
                if (this.visited[i] != 1 && this.maze[front - 1][i - 1] == 1) {
                    this.visited[i] = 1;
                    q.add(i);
                }
            }
        }
    }

    public void DFS(int start) {
        this.visited[start] = 1;
        for (int i = 1; i <= this.n; i++) {
            if (this.visited[i] != 1 && this.maze[start - 1][i - 1] == 1) {
                DFS(i);
            }
        }
        System.out.print(start + " ");
    }

    public void DFS2(int start){
        Stack<Integer> s = new Stack<>();
        s.add(start);
        this.visited[start] = 1;
        boolean isPush = false;
        while (!s.isEmpty()) {
            //深度到底
            isPush = false;
            int v = s.peek();
            for(int i = 1;i <= this.n;i++) {
                if(this.visited[i] != 1 && this.maze[v - 1][i - 1] == 1) {
                    this.visited[i] = 1;
                    s.add(i);
                    isPush = true;
                    break;
                }
            }
            //isPush为false表示遍历到最深深度都没有push相邻节点进来，说明是最深的节点了，可以输出
            if(!isPush) {
                System.out.print(v + " ");
                s.pop();
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] mazeBFS = {
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0}
        };
        int[][] mazeDFS = {
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 1, 0, 0}
        };
        int[] visitedBFS = new int[n + 1];
        RetrieveBD retrieveBDBFS = new RetrieveBD(n, mazeBFS, visitedBFS);
        System.out.println("BFS:");
        for (int i = 1; i < n; i++) {
            if (visitedBFS[i] == 1) continue;
            retrieveBDBFS.BFS(i);
        }
        System.out.println();

        int[] visitedDFS = new int[n + 1];
        RetrieveBD retrieveBDDFS1 = new RetrieveBD(n, mazeDFS, visitedDFS);
        System.out.println("DFS:");
        for (int i = 1; i < n; i++) {
            if (visitedDFS[i] == 1) continue;
            retrieveBDDFS1.DFS(i);
        }
        System.out.println();

        int[] visitedDFS2 = new int[n + 1];
        RetrieveBD retrieveBDDFS2 = new RetrieveBD(n, mazeDFS, visitedDFS2);
        System.out.println("DFS:");
        for (int i = 1; i < n; i++) {
            if (visitedDFS2[i] == 1) continue;
            retrieveBDDFS2.DFS2(i);
        }
    }
}
