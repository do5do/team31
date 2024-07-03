package doh._07._0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class 빌런호석_22251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 자리 수
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] nums = new int[10][7];
        nums[0] = new int[] {1, 1, 1, 0, 1, 1, 1};
        nums[1] = new int[] {0, 0, 1, 0, 0, 0, 1};
        nums[2] = new int[] {1, 0, 1, 1, 1, 1, 0};
        nums[3] = new int[] {1, 0, 1, 1, 0, 1, 1};
        nums[4] = new int[] {0, 1, 1, 1, 0, 0, 1};
        nums[5] = new int[] {1, 1, 0, 1, 0, 1, 1};
        nums[6] = new int[] {1, 1, 0, 1, 1, 1, 1};
        nums[7] = new int[] {1, 0, 1, 0, 0, 0, 1};
        nums[8] = new int[] {1, 1, 1, 1, 1, 1, 1};
        nums[9] = new int[] {1, 1, 1, 1, 0, 1, 1};

        int[] numIdx = getNumIdx(x, k);
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }

            int[] targetNumIdx = getNumIdx(i, k);
            int diffCnt = 0;
            out: for (int j = 0; j < k; j++) {
                for (int l = 0; l < nums[0].length; l++) {
                    if (nums[numIdx[j]][l] != nums[targetNumIdx[j]][l]) {
                        diffCnt++;

                        if (diffCnt > p) {
                            break out;
                        }
                    }
                }
            }

            if (diffCnt <= p) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static int[] getNumIdx(int x, int k) {
        int[] numsIdx = new int[k];
        int idx = 0;

        while (x > 0) {
            numsIdx[idx++] = x % 10;
            x /= 10;
        }

        return numsIdx;
    }
}
