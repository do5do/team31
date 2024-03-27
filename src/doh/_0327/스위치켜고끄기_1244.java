package doh._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기_1244 {
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 스위치 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        switches = new int[n];
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); // 학생 수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (idx == 1) { // 남학생
                boyTurn(num);
            } else {
                girlTurn(num - 1); // index로 넘김
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < switches.length; i++) {
            if (i >= 20 && i % 20 == 0) {
                sb.append("\n");
            }
            sb.append(switches[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void boyTurn(int num) {
        for (int i = num; i <= switches.length; i++) {
            if (i % num == 0) {
                turn(i - 1);
            }
        }
    }

    public static void girlTurn(int num) {
        turn(num);
        int p1 = num - 1;
        int p2 = num + 1;

        while (p1 >= 0 && p2 < switches.length) {
            if (switches[p1] == switches[p2]) {
                turn(p1);
                turn(p2);
                p1--;
                p2++;
            } else {
                break;
            }
        }
    }

    public static void turn(int idx) {
        switches[idx] = switches[idx] == 0 ? 1 : 0;
    }
}
