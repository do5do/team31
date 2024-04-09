package doh._03._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수리공항승_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken()); // 테이프 길이

        st = new StringTokenizer(br.readLine());
        int[] hole = new int[n];

        for (int i = 0; i < n; i++) {
            hole[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hole);

        if (l == 1) {
            System.out.println(n);
            System.exit(0);
        }

        int cnt = 1;

        // 현재 위치에서 몇개까지 막을 수 있는지?
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int size = hole[j] - hole[i];

                if (size > l - 1) { // 다음칸까지는 못막음
                    cnt++;
                    i = j - 1;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
