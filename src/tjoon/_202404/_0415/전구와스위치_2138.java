package tjoon._202404._0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전구와스위치_2138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] originLights = new int[n];
        int[] wantLights = new int[n];

        String origin = br.readLine();
        String want = br.readLine();
        for (int i = 0; i < n; i++) {
            originLights[i] = origin.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            wantLights[i] = want.charAt(i) - '0';
        }

        int[] copyLights = Arrays.copyOf(originLights, n);
        copyLights[0] = 1 - copyLights[0];
        copyLights[1] = 1 - copyLights[1];

        int originCnt = 0;
        int copyCnt = 1; // 0번 스위치 한번 켬

        for (int i = 1; i < n; i++) {
            if (originLights[i - 1] != wantLights[i - 1]) {
                changeLights(i, originLights);
                originCnt++;
            }
            if (copyLights[i - 1] != wantLights[i - 1]) {
                changeLights(i, copyLights);
                copyCnt++;
            }

            if (Arrays.equals(originLights, wantLights)) {
                if (Arrays.equals(originLights, copyLights)) {
                    System.out.println(Math.min(originCnt, copyCnt));
                    System.exit(0);
                }
                System.out.println(originCnt);
                System.exit(0);
            } else if (Arrays.equals(copyLights, wantLights)) {
                System.out.println(copyCnt);
                System.exit(0);
            }
        }

        System.out.println(-1);
    }

    private static void changeLights(int idx, int[] arr) {
        arr[idx - 1] = 1 - arr[idx - 1];
        arr[idx] = 1 - arr[idx];

        if (idx + 1 < arr.length) {
            arr[idx + 1] = 1 - arr[idx + 1];
        }
    }
}
