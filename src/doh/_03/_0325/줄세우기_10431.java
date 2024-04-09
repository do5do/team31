package doh._03._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄세우기_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;

            for (int j = 1; j < list.size(); j++) {
                for (int k = j - 1; k >= 0; k--) {
                    if (list.get(k) > list.get(j)) {
                        cnt++;
                    }
                }
            }

            sb.append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
