package doh._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 올림픽_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations[i] = new Nation(idx, gold, silver, bronze);
        }

        Arrays.sort(nations);
        int answer = 0; // 1등인 경우를 출력하기 위해 변수로 빼준다.
        nations[0].rank = 1;
        for (int i = 1; i < n; i++) {
            Nation prev = nations[i - 1];
            Nation cur = nations[i];

            // 동률
            if (prev.gold == cur.gold
                    && prev.silver == cur.silver
                    && prev.bronze == cur.bronze) {
                cur.rank = prev.rank;
            } else {
                cur.rank = i + 1;
            }

            if (cur.idx == k) {
                answer = i;
                break;
            }
        }

        System.out.println(nations[answer].rank);
    }

    static class Nation implements Comparable<Nation> {
        int idx;
        int gold, silver, bronze;
        int rank;

        public Nation(int idx, int gold, int silver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            int result = Integer.compare(o.gold, gold);
            if (result == 0) {
                result = Integer.compare(o.silver, silver);
                if (result == 0) {
                    result = Integer.compare(o.bronze, bronze);
                }
            }
            return result;
        }
    }
}
