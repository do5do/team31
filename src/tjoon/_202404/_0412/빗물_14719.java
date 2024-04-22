package tjoon._202404._0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_14719 {

    static int h, w;
    static int[][] board;
    static int[] load;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        board = new int[h][w];
        load = new int[w];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < w; i++) {
            load[i] = Integer.parseInt(st.nextToken());

            if (load[i] > max) {
                max = load[i];
                maxIdx = i;
            }
        }

        // 양끝이 막혀있어야됨
        // 양끝 높이 기준

        // 왼쪽끝
        int leftIdx = -1;
        for (int i = 0; i < maxIdx; i++) {
            if (load[i] != 0) {
                leftIdx = i; // 왼쪽에서 최대높이 저장
                break;
            }
        }

        // 오른쪽끝
        int rightIdx = -1;
        for (int i = w - 1; i > maxIdx; i--) {
            if (load[i] != 0) {
                rightIdx = i;
                break;
            }
        }

        // 1 2 3 2 1
        int sum = 0;
        int leftMax = 0;
        if (leftIdx != -1) {
            for (int i = leftIdx; i < maxIdx; i++) {
                if (load[i] > leftMax) {
                    leftMax = load[i];
                }
                if (load[i] < leftMax) {
                    sum += (leftMax - load[i]);
                }
            }
        }

        int rightMax = 0;
        if (rightIdx != -1) {
            for (int i = rightIdx; i > maxIdx; i--) {
                if (load[i] > rightMax) {
                    rightMax = load[i];
                }
                if (load[i] < rightMax) {
                    sum += (rightMax - load[i]);
                }
            }
        }

        System.out.println(sum);

    }
}
