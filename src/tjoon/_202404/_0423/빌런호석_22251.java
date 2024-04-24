package tjoon._202404._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌런호석_22251 {

    static int[][] light = {
            {1, 1, 1, 0, 1, 1, 1}, // 0
            {0, 0, 1, 0, 0, 1, 0}, // 1
            {1, 0, 1, 1, 1, 0, 1}, // 2
            {1, 0, 1, 1, 0, 1, 1}, // 3
            {0, 1, 1, 1, 0, 1, 0}, // 4
            {1, 1, 0, 1, 0, 1, 1}, // 5
            {1, 1, 0, 1, 1, 1, 1}, // 6
            {1, 0, 1, 0, 0, 1, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1} // 9
    };
    static int n, k, p, x;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 엘베 층수
        k = Integer.parseInt(st.nextToken()); // ex) k == 2, 3 -> 03
        p = Integer.parseInt(st.nextToken()); // // 최대 반전 개수
        x = Integer.parseInt(st.nextToken()); // 현재 층수

        int[][] display = convertToDisplay(x);

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }

            int[][] tmpDisplay = convertToDisplay(i);
            int diffCount = getDiffCount(display, tmpDisplay);

            if (diffCount >= 1 && diffCount <= p) {
                count++;
            }

        }

        System.out.println(count);

    }

    private static int getDiffCount(int[][] display, int[][] tmpDisplay) {
        int diffCount = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 7; j++) {
                if (display[i][j] != tmpDisplay[i][j]) {
                    diffCount++;
                }
            }
        }

        return diffCount;
    }

    private static int[][] convertToDisplay(int x) {
        int[][] display = new int[k][7];

        for (int i = display.length - 1; i >= 0; i--) {
            display[i] = light[x % 10];
            x /= 10;
        }

        return display;
    }
}
