package doh._03._0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 8979 올림픽
 */
public class Olympic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 국가 수
        int k = Integer.parseInt(st.nextToken()); // 알고싶은 국가

        List<Nation> nations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations.add(new Nation(number, gold, silver, bronze));
        }

        Collections.sort(nations);
        nations.get(0).rank = 1;
        int target = 0;

        for (int i = 1; i < n; i++) {
            if (nations.get(i - 1).gold == nations.get(i).gold &&
                    nations.get(i - 1).silver == nations.get(i).silver &&
                    nations.get(i - 1).bronze == nations.get(i).bronze) {
                // 공동
                nations.get(i).rank = nations.get(i - 1).rank;
            } else {
                nations.get(i).rank = i + 1; // 현재 등수
            }

            if (nations.get(i).number == k) {
                target = i;
                break; // 이게 문제가 아니라 등수를 잘못구해서 틀렸던거 였음
            }
        }

        System.out.println(nations.get(target).rank);
    }

    static class Nation implements Comparable<Nation> {
        int number;
        int gold;
        int silver;
        int bronze;
        int rank = 0;

        public Nation(int number, int gold, int silver, int bronze) {
            this.number = number;
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
