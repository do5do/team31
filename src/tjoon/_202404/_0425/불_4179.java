package tjoon._202404._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_4179 {

    static int r, c;
    static char[][] board;
    static int[][] jihoon;
    static int[][] fireTime;
    static Queue<Node> fQueue = new LinkedList<>();
    static Queue<Node> jQueue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        jihoon = new int[r][c];
        fireTime = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(jihoon[i], -1);
            Arrays.fill(fireTime[i], -1);
        }

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);

                if (board[i][j] == 'J') {
                    jQueue.add(new Node(i, j));
                    jihoon[i][j] = 0;
                }

                if (board[i][j] == 'F') {
                    fQueue.add(new Node(i, j));
                    fireTime[i][j] = 0;
                }
            }
        }

        bfs();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (i == 0 || i == (r - 1) || j == 0 || j == (c - 1)) {

                    if (jihoon[i][j] == -1) {
                        continue;
                    }

                    min = Math.min(min, jihoon[i][j]);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(min + 1);
        }

    }

    private static void bfs() {

        while (!fQueue.isEmpty()) {
            Node cur = fQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c
                        && board[nx][ny] != '#' // 벽 x
                        && fireTime[nx][ny] == -1) { // 아직 닿지않은 칸

                    fQueue.add(new Node(nx, ny));
                    fireTime[nx][ny] = fireTime[cur.x][cur.y] + 1;
                }
            }
        }

        while (!jQueue.isEmpty()) {
            Node cur = jQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c
                        && board[nx][ny] != '#'
                        && jihoon[nx][ny] == -1
                        && (jihoon[cur.x][cur.y] + 1 < fireTime[nx][ny] || fireTime[nx][ny] == -1)) {

                    jQueue.add(new Node(nx, ny));
                    jihoon[nx][ny] = jihoon[cur.x][cur.y] + 1;

                }
            }
        }

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
