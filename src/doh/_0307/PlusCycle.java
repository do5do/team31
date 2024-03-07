package doh._0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1110 더하기 사이클
 */
public class PlusCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int originN = n;
        int cnt = 0;

        while (true) {
            int lastNum = n % 10;
            int firstNum = n / 10;
            int sum = lastNum + firstNum;

            // 새로운 수
            n = Integer.parseInt(lastNum + "" + sum % 10);
            cnt++;

            if (n == originN) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
