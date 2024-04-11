package tjoon._202404._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_20055 {

    static int n, k;
    static int[] belt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[n * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < belt.length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] exists = new boolean[n];

        int index = 0;
        while (check()) {
            index++;

            // 벨트 위치 옮기기
            int temp = belt[n * 2 - 1];
            for (int i = belt.length - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = temp;

            for (int i = exists.length - 1; i > 0; i--) {
                exists[i] = exists[i - 1];
            }
            exists[0] = false; // 처음값 입력
            exists[n - 1] = false; // 마지막 도착하면 내려

            for (int i = exists.length - 1; i > 0; i--) { // 로봇 옮기기
                if (exists[i - 1] && !exists[i] && belt[i] > 0) {
                    exists[i] = true;
                    exists[i - 1] = false;
                    belt[i]--;
                }
            }

            if (belt[0] > 0) {
                exists[0] = true;
                belt[0]--;
            }
        }

        System.out.println(index);

    }

    private static boolean check() {
        int count = 0;
        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0) {
                count++;
            }
        }

        if (count >= k) {
            return false;
        }

        return true;
    }
}
