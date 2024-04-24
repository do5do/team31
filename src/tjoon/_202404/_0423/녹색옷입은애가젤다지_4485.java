package tjoon._202404._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485 {

    static int n = -1;
    static int[][] board;
    static int[][] sum; // 그 칸 합
    static int idx = 1; // 현재 problem
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while ((n = Integer.parseInt(br.readLine())) != 0) {

            board = new int[n][n];
            sum = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(sum[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(idx++).append(": ");
            sb.append(bfs()).append("\n");

        }

        System.out.println(sb);
    }

    private static int bfs() {

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, board[0][0]));
        sum[0][0] = board[0][0];

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == (n - 1) && cur.y == (n - 1)) {
                return cur.min;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (cur.min + board[nx][ny] < sum[nx][ny]) {
                        sum[nx][ny] = cur.min + board[nx][ny]; // 최소값으로 갱신
                        queue.add(new Node(nx, ny, sum[nx][ny]));
                    }
                }
            }

        }

        return 0;
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int min;

        public Node(int x, int y, int min) {
            this.x = x;
            this.y = y;
            this.min = min;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.min, o.min);
        }
    }
}
