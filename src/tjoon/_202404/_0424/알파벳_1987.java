package tjoon._202404._0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {

    static int r, c;
    static int[][] alpha;
    static boolean[] visited = new boolean[26];
    //    static List<Character> list = new ArrayList<>();
    static int count = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alpha = new int[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                alpha[i][j] = s.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);

        System.out.println(count);

    }

    private static void dfs(int x, int y, int idx) {

        count = Math.max(count, idx);
        visited[alpha[x][y]] = true;
//        list.add(alpha[x][y]);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!visited[alpha[nx][ny]]) {
                    dfs(nx, ny, idx + 1);
                    visited[alpha[nx][ny]] = false;
//                    list.remove(Character.valueOf(alpha[nx][ny]));
                }
            }
        }

    }

}
