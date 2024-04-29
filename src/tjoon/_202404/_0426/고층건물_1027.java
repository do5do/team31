package tjoon._202404._0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고층건물_1027 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] buildings = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        // 기울기가 더 작은것만 가능
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0; // 각 빌딩마다 보이는개수

            double inclination = 0; // 왼쪽 기울기
            double cur = 0;
            for (int j = i - 1; j >= 0; j--) { // i 왼쪽에서 왼쪽 끝까지
                cur = (double) (buildings[i] - buildings[j]) / (i - j);

                if (j == (i - 1) || inclination > cur) {  // 기울기가 작은것만 해당
                    inclination = cur;
                    count++;
                }

            }

            inclination = 0; // 오른쪽 기울기
            for (int j = i + 1; j < n; j++) { // i 오른쪽에서 오른쪽 끝까지
                cur = (double) (buildings[i] - buildings[j]) / (j - i);

                if (j == (i + 1) || inclination > cur) {  // 기울기가 작은것만 해당
                    inclination = cur;
                    count++;
                }

            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
