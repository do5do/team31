package doh._04._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 컨베이어벨트위의로봇_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Belt> belts = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int upIdx = 0;
        int downIdx = n - 1;
        int lastIdx = 2 * n - 1;

        for (int i = 0; i < n * 2; i++) {
            belts.add(new Belt(Integer.parseInt(st.nextToken())));
        }

        int zeroCount = 0;
        int cnt = 0; // 단계

        while (zeroCount < k) {
            cnt++;

            // 벨트 회전
            belts.add(0, belts.get(lastIdx));

            // 로봇 내림
            Belt downBelt = belts.get(downIdx);
            if (downBelt.existRobot) {
                downBelt.existRobot = false;
            }

            // 가장 먼저 올라간 로봇부터 오른쪽으로 이동
            for (int i = lastIdx - 1; i > 0; i--) {
                Belt cur = belts.get(i);

                if (cur.existRobot) {
                    Belt next = belts.get(i + 1);

                    if (!next.existRobot && next.weight > 0) { // 이동 가능
                        if (i + 1 != downIdx) { // 다음 칸이 내릴 위치가 아닌 경우
                            next.existRobot = true;
                        }

                        // 다음 위치로 로봇 이동
                        next.weight--;
                        cur.existRobot = false;
                        if (next.weight == 0) {
                            zeroCount++;
                        }
                    }
                }
            }

            // 로봇 올림
            Belt upBelt = belts.get(upIdx);
            if (upBelt.weight > 0) {
                upBelt.existRobot = true;
                upBelt.weight--;

                if (upBelt.weight == 0) {
                    zeroCount++;
                }
            }
        }

        System.out.println(cnt);
    }

    static class Belt {
        boolean existRobot;
        int weight; // 내구도

        public Belt(int weight) {
            this.weight = weight;
        }
    }
}

// 시초..