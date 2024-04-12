package tjoon._202404._0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동_16234 {

    static int n, l, r;
    static int[][] board;
    static boolean[][] visited;
    static List<Node> unit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean flag = false; // 움직인적은 있나 체크

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) { // 방문한적이 없으면
                        int sum = bfs(i, j);
                        if (unit.size() > 1) {
                            int avg = sum / unit.size();
                            for (Node node : unit) {
                                board[node.x][node.y] = avg;
                            }
                            flag = true;
                        }
                    }
                }
            }

            if (!flag) {
                break;
            }

            count++;
        }

        System.out.println(count);

    }

    private static int bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        unit = new ArrayList<>();

        queue.offer(new Node(x, y));
        unit.add(new Node(x, y));
        visited[x][y] = true;

        int sum = board[x][y];

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny]) { // 다음노드가 방문한적이 없으면
                        int abs = Math.abs(board[cur.x][cur.y] - board[nx][ny]);

                        if (abs >= l && abs <= r) {
                            visited[nx][ny] = true;
                            queue.offer(new Node(nx, ny));
                            unit.add(new Node(nx, ny));
                            sum += board[nx][ny];
                        }
                    }
                }
            }
        }

        return sum;

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
