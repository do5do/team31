package doh._03._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] distance = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long total = ((long) distance[0]) * cost[0];
        int curCost = cost[0];
        for (int i = 1; i < n; i++) {
            if (curCost > cost[i]) {
                curCost = cost[i];
            }
            total += ((long) distance[i]) * curCost;
        }

        System.out.println(total);
    }
}
