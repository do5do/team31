package doh._04._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0만들기_7490 {
    static int n;
    static char[] result;
    static char[] mark = new char[] {' ', '+', '-'};
    static StringBuilder sb = new StringBuilder();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            t--;
            n = Integer.parseInt(br.readLine());
            result = new char[n - 1];
            dfs(0);
            answer.append("\n");
        }

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == n - 1) {
            // 띄어쓰기 고려하여 식 만들기
            int num = 1;
            sb.append(num);
            for (int i = 0; i < n - 1; i++) {
                num++;
                if (result[i] == '+') {
                    sb.append(result[i]).append(num);
                } else if (result[i] == '-') {
                    sb.append(result[i]).append(num);
                } else {
                    sb.append(num);
                }
            }

            // 식 계산
            int sum = getSum();

            // 출력 넣기
            if (sum == 0) {
                num = 1;
                answer.append(num);
                for (int i = 0; i < n - 1; i++) {
                    num++;
                    if (result[i] == '+') {
                        answer.append(result[i]).append(num);
                    } else if (result[i] == '-') {
                        answer.append(result[i]).append(num);
                    } else {
                        answer.append(" ").append(num);
                    }
                }
                answer.append("\n");
            }

            sb.setLength(0);
            return;
        }

        for (int i = 0; i < 3; i++) {
            result[depth] = mark[i];
            dfs(depth + 1);
            result[depth] = '0';
        }
    }

    private static int getSum() {
        String str = sb.toString();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - '0';

            if (a >= 0 && a <= 9) {
                int j = i;
                while (true) {
                    j++;
                    if (j >= str.length()) {
                        break;
                    }

                    int b = str.charAt(j) - '0';
                    if (b >= 0 && b <= 9) {
                        a = a * 10 + b;
                    } else {
                        break;
                    }
                }
            }

            if (i == 0) {
                sum = a;
            } else {
                if (str.charAt(i - 1) == '+') {
                    sum += a;
                } else if (str.charAt(i - 1) == '-') {
                    sum -= a;
                }
            }
        }
        return sum;
    }
}
