package tjoon._202404._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영만들기_7490 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            dfs(n, 1, new char[n]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int n, int cnt, char[] arr) {
        if (cnt == n) {
            if (result(arr, n)) {
                for (int i = 1; i <= n; i++) {
                    if (i != n) {
                        sb.append(i).append(arr[i]);
                    } else {
                        sb.append(i);
                    }
                }
                sb.append('\n');
            }
            return;
        }

        arr[cnt] = ' ';
        dfs(n, cnt + 1, arr);

        arr[cnt] = '+';
        dfs(n, cnt + 1, arr);

        arr[cnt] = '-';
        dfs(n, cnt + 1, arr);
    }

    public static boolean result(char[] arr, int N) {
        int sum = 0;

        for (int i = N; i > 1; i--) {

            int num = i;
            if (arr[i - 1] == '+') {
                sum += num;
            } else if (arr[i - 1] == '-') {
                sum -= num;
            } else {

                int result = i;
                int cnt = 1;
                while (arr[i - 1] == ' ') {
                    i--;
                    result += i * (int) Math.pow(10, cnt++);
                }

                if (i - 1 >= 1 && arr[i - 1] == '-') {
                    sum -= result;
                } else {
                    sum += result;
                }
            }

        }

        if (arr[1] != ' ') {
            sum += 1;
        }

        return sum == 0;
    }
}
