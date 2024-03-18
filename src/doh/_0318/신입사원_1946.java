package doh._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입사원_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Rank[] ranks = new Rank[n];

            StringTokenizer st;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                ranks[j] = new Rank(a, b);
            }

            Arrays.sort(ranks);
            int cnt = 1;
            Rank min = ranks[0];

            for (int j = 1; j < n; j++) {
                Rank cur = ranks[j];

                if (cur.b < min.b) { // 면접 시험 순위 비교
                    cnt++; // 현재 사람 뽑음
                    min = ranks[j];
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static class Rank implements Comparable<Rank> {
        int a, b;

        public Rank(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Rank o) { // 서류 심사 순위 순 정렬
            return Integer.compare(a, o.a);
        }
    }
}
