package doh._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {
    static int[][] matrix;
    static boolean[] visited;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken()) - 1;

        matrix = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        dfs(v);
        visited = new boolean[n];
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (visited[depth]) {
            return;
        }

        visited[depth] = true;
        sb.append(depth + 1).append(" ");

        for (int i = 0; i < n; i++) {
            if (!visited[i] && matrix[depth][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int depth) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(depth);
        visited[depth] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur + 1).append(" ");

            for (int i = 0; i < n; i++) {
                if (!visited[i] && matrix[cur][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
