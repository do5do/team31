package doh._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 볼모으기_17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int answer = 0;

        // 왼쪽에 빨간공을 모으는 경우 처음 파란공이 나온 이후부터 빨간공 개수 세기
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'B') {
                flag = true;
                continue;
            }

            if (flag && balls.charAt(i) == 'R') {
                cnt++;
            }
        }
        answer = cnt;

        // 왼쪽에 파란공을 모으는 경우
        cnt = 0;
        flag = false;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'R') {
                flag = true;
                continue;
            }

            if (flag && balls.charAt(i) == 'B') {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        // 오른쪽에 빨간공을 모으는 경우
        cnt = 0;
        flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B') {
                flag = true;
                continue;
            }

            if (flag && balls.charAt(i) == 'R') {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        // 오른쪽에 파란공을 모으는 경우
        cnt = 0;
        flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R') {
                flag = true;
                continue;
            }

            if (flag && balls.charAt(i) == 'B') {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        System.out.println(answer);
    }
}
