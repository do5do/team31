package taehee.problem._1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean[] primes = new boolean[2000001];

    for (int i = 2; i < primes.length; i++) {
      primes[i] = true;
    }

    for (int i = 2; i * i < primes.length; i++) {
      if (primes[i]) {
        for (int j = i * i; j < primes.length; j += i) {
          primes[j] = false;
        }
      }
    }

    for (int i = N; i < primes.length; i++) {
      if (primes[i] && isPalindrome(i)) {
        System.out.println(i);
        break;
      }
    }
  }

  static boolean isPalindrome(Integer num) {
    String numString = num.toString();
    StringBuilder sb = new StringBuilder(numString);
    String reverseString = sb.reverse().toString();
    return numString.equals(reverseString);
  }
}
