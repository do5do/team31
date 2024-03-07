package doh._0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1747 소수 & 팰린드롬
 */
public class PrimeNumberAndPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 1_004_000;
        int[] prime = new int[max + 1];
        prime[0] = prime[1] = -1; // 소수 아님

        // 소수 판별
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (prime[i] == -1) {
                continue;
            }

            for (int j = i + i; j <= max; j += i) {
                prime[j] = -1;
            }
        }

        // 확인
        for (int i = n; i <= max; i++) {
            if (prime[i] == 0 && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}