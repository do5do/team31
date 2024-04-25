package doh._04._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_4179 {
    static int r, c;
    static char[][] matrix;
    static int[] start = new int[2];
    static int[] fire = new int[2];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;
    static Queue<int[]> fireQueue = new LinkedList<>();
    static boolean[][] fireVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new char[r][c];
        fireVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'J') {
                    start[0] = i;
                    start[1] = j;
                } else if (matrix[i][j] == 'F') {
                    fireQueue.offer(new int[] {i, j, 0});
                    fireVisited[i][j] = true;
                }
            }
        }

        bfsFire();
        bfs();

        if (min == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(min);
        }
    }

    static void bfsFire() {
        while (!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int time = cur[2] + 1;

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (!fireVisited[nx][ny] && matrix[nx][ny] == '.') {
                        fireVisited[nx][ny] = true;
                        matrix[nx][ny] = (char) (time + '0');
                        fireQueue.offer(new int[] {nx, ny, time});
                    }
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 1});
        boolean[][] visited = new boolean[r][c];
        visited[start[0]][start[1]] = true;
        visited[fire[0]][fire[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int time = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (!visited[nx][ny] && matrix[nx][ny] != '#' && matrix[nx][ny] != 'F') {
                        int nextTime = matrix[nx][ny] - '0';
                        if (nextTime < 0) { // .
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny, time + 1});
                            continue;
                        }

                        if (nextTime > time) {
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny, time + 1});
                        }
                    }
                } else {
                    // 가장자리
                    min = Math.min(cur[2], min);
                }
            }
        }
    }
}