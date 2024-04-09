package doh._03._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리_17266 {
    static int[] place;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 굴다리 길이
        int m = Integer.parseInt(br.readLine()); // 가로등 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        place = new int[m]; // 가로등 위치

        for (int i = 0; i < m; i++) {
            place[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = n;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static boolean check(int height) {
        int prev = 0;

        for (int i = 0; i < place.length; i++) {
            if (place[i] - height <= prev) {
                prev = place[i] + height;
            } else {
                return false;
            }
        }

        return n - prev <= 0;
    }
}
