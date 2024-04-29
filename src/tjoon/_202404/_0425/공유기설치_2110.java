package tjoon._202404._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {

    static int[] home;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        home = new int[n];
        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int left = 1;
        int right = home[n - 1] - home[0] + 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if (canInstall(mid) < c) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);

    }

    private static int canInstall(int distance) {

        int count = 1;
        int lastLocate = home[0];

        for (int i = 1; i < home.length; i++) {
            int locate = home[i];

            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }

        return count;

    }
}
