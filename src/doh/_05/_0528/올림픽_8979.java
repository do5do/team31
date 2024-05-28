package doh._05._0528;

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
        nations[0].rank = 1;
        int answer = nations[0].rank; // 0번인 경우

        for (int i = 1; i < n; i++) {
            Nation prev = nations[i - 1];
            Nation cur = nations[i];

            if (cur.gold == prev.gold && cur.silver == prev.silver && cur.bronze == prev.bronze) {
                cur.rank = prev.rank;
            } else {
                cur.rank = i + 1;
            }

            if (cur.idx == k) {
                answer = cur.rank;
                break;
            }
        }

        System.out.println(answer);
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
