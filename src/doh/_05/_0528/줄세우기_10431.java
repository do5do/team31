package doh._05._0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 줄세우기_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            List<Integer> list = new LinkedList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;
            for (int j = 1; j < list.size(); j++) {
                for (int k = 0; k < j; k++) {
                    if (list.get(j) < list.get(k)) {
                        cnt += j - k;
                        int cur = list.get(j);
                        list.remove(j);
                        list.add(k, cur);
                        break;
                    }
                }
            }

            sb.append(String.format("%d %d", t, cnt)).append("\n");
        }

        System.out.println(sb);
    }
}
