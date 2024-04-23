package doh._04._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌런호석_22251 {
    static int k, p;
    static int[] cur;
    static int[][] bit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken()); // 최대 반전 개수
        int x = Integer.parseInt(st.nextToken()); // 현재 층

        bit = new int[10][7];
        bit[0] = new int[] {1, 1, 1, 0, 1, 1, 1};
        bit[1] = new int[] {0, 0, 1, 0, 0, 0, 1};
        bit[2] = new int[] {1, 0, 1, 1, 1, 1, 0};
        bit[3] = new int[] {1, 0, 1, 1, 0, 1, 1};
        bit[4] = new int[] {0, 1, 1, 1, 0, 0, 1};
        bit[5] = new int[] {1, 1, 0, 1, 0, 1, 1};
        bit[6] = new int[] {1, 1, 0, 1, 1, 1, 1};
        bit[7] = new int[] {1, 0, 1, 0, 0, 0, 1};
        bit[8] = new int[] {1, 1, 1, 1, 1, 1, 1};
        bit[9] = new int[] {1, 1, 1, 1, 0, 1, 1};

        cur = getNum(x);
        long answer = 0;

        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }

            if (check(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean check(int target) { // target을 만들수 있는지 확인
        int[] temp = getNum(target);
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 7; j++) {
                if (bit[temp[i]][j] != bit[cur[i]][j]) {
                    cnt++;
                    if (cnt > p) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static int[] getNum(int num) { // 자리수에 맞게 변경
        int[] nums = new int[k];
        int idx = k - 1;

        while (num > 0) {
            nums[idx--] = num % 10;
            num /= 10;
        }

        return nums;
    }
}
