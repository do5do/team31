package doh._04._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 녹색옷입은애가젤다지_4485 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while (n != 0) {
            int[][] matrix = new int[n][n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, matrix[0][0]));
            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = matrix[0][0];
            boolean[][] visited = new boolean[n][n];

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (visited[cur.x][cur.y]) {
                    continue;
                }
                visited[cur.x][cur.y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (dist[nx][ny] > dist[cur.x][cur.y] + matrix[nx][ny]) {
                            dist[nx][ny] = dist[cur.x][cur.y] + matrix[nx][ny];
                            pq.offer(new Node(nx, ny, dist[nx][ny]));
                        }
                    }
                }
            }

            sb.append(String.format("Problem %d: %d", idx, dist[n - 1][n - 1])).append("\n");
            n = Integer.parseInt(br.readLine());
            idx++;
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int x, y, weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
