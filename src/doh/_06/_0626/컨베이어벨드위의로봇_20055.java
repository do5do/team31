package doh._06._0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨드위의로봇_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] belt = new int[n * 2];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < belt.length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        int zeroCnt = 0;
        boolean[] robots = new boolean[n]; // 로봇 유무(== 짐 유무)

        while (zeroCnt < k) {
            // 벨트, 로봇 회전
            int temp = belt[belt.length - 1];
            for (int i = belt.length - 1; i >= 1; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = temp;

            for (int i = robots.length - 1; i >= 1; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false; // 첫번째 로봇은 항상 비워줌
            robots[n - 1] = false; // 내리는 위치에서 로봇 내림

            // 로봇 이동
            for (int i = robots.length - 1; i >= 1; i--) {
                if (!robots[i] && robots[i - 1] && belt[i] >= 1) {
                    robots[i] = true;
                    robots[i - 1] = false;
                    belt[i]--;

                    if (belt[i] == 0) {
                        zeroCnt++;
                    }
                }
            }

            // 올리는 위치 내구도 확인
            if (belt[0] >= 1) {
                belt[0]--;
                robots[0] = true;

                if (belt[0] == 0) {
                    zeroCnt++;
                }
            }
            step++;
        }

        System.out.println(step);
    }
}
