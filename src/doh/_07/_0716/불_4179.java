package doh._07._0716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불_4179 {
    static int r, c;
    static char[][] matrix;
    static int[] start;
    static Queue<int[]> fires = new LinkedList<>();
    static boolean[][] fireVisited;
    static int[][] fireMatrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new char[r][c];
        start = new int[2];
        fireVisited = new boolean[r][c];
        fireMatrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = line.charAt(j);
                matrix[i][j] = ch;

                if (ch == 'J') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'F') {
                    fires.offer(new int[] {i, j});
                    fireVisited[i][j] = true;
                }
            }
        }

        bfsFire();
        bfs();

        if (minCnt == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(minCnt + 1);
        }
    }

    public static void bfsFire() {
        while (!fires.isEmpty()) {
            int[] cur = fires.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (!fireVisited[nx][ny] && matrix[nx][ny] == '.') {
                        fireVisited[nx][ny] = true;
                        fireMatrix[nx][ny] = fireMatrix[cur[0]][cur[1]] + 1;
                        fires.offer(new int[] {nx, ny, fireMatrix[nx][ny]});
                    }
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});
        boolean[][] visited = new boolean[r][c];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int next = cur[2] + 1;

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (!visited[nx][ny] && matrix[nx][ny] == '.') {
                        if (fireMatrix[nx][ny] > 0 && next >= fireMatrix[nx][ny]) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, next});
                    }
                } else {
                    minCnt = Math.min(cur[2], minCnt);
                }
            }
        }
    }
}
