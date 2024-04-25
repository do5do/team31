package doh._04._0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 알파벳_1987 {
    static int r, c;
    static char[][] matrix;
    static boolean[][] visited;
    static int max;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        matrix = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        visited[0][0] = true;
        HashSet<Character> path = new HashSet<>();
        path.add(matrix[0][0]);

        dfs(0, 0, path, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, Set<Character> path, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!visited[nx][ny] && !path.contains(matrix[nx][ny])) {
                    visited[nx][ny] = true;
                    path.add(matrix[nx][ny]);
                    dfs(nx, ny, path, cnt + 1);
                    path.remove(matrix[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }

        max = Math.max(cnt, max);
    }
}