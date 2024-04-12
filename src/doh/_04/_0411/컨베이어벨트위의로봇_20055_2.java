package doh._04._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_20055_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int m = n * 2;
        int[] belts = new int[m];
        int[] robots = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            belts[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int zeroCnt = 0;

        while (zeroCnt < k) {
            answer++;
            // 벨트 회전
            int last = belts[m - 1];
            for (int i = m - 1; i >= 1; i--) {
                belts[i] = belts[i - 1];
            }
            belts[0] = last;

            // 로봇 이동
            for (int i = n - 1; i >= 1; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = 0;
            robots[n - 1] = 0; // 로봇 내림

            // 가장 먼저 올라간 로봇부터 오른쪽으로 이동
            for (int i = n - 2; i > 0; i--) {
                if (robots[i] == 1) {
                    // 앞으로 이동 가능하면
                    if (robots[i + 1] != 1 && belts[i + 1] > 0) {
                        belts[i + 1]--;
                        robots[i] = 0;
                        robots[i + 1] = 1;

                        if (belts[i + 1] == 0) {
                            zeroCnt++;
                        }
                    }
                }
            }

            // 로봇 올림
            if (belts[0] > 0) {
                belts[0]--;
                robots[0] = 1;
                if (belts[0] == 0) {
                    zeroCnt++;
                }
            }
        }

        System.out.println(answer);
    }
}
