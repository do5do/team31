package tjoon._202404._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전초밥_2531 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int[] sushi = new int[n];
        int[] eat = new int[d + 1];

        for (int i = 0; i < n; ++i) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; ++i) {
            eat[sushi[i]]++;
            if (eat[sushi[i]] == 1) {
                cnt++;
            }
            right++;
        }
        ans = cnt;

        while (left != n) {
            eat[sushi[left]]--;
            if (eat[sushi[left]] == 0) {
                cnt--;
            }
            left++;

            eat[sushi[right]]++;
            if (eat[sushi[right]] == 1) {
                cnt++;
            }
            right++;
            if (right == n) {
                right = 0;
            }
            if (eat[c] == 0) {
                ans = Math.max(ans, cnt + 1);
            } else {
                ans = Math.max(ans, cnt);
            }
        }

        System.out.println(ans);

    }

}
