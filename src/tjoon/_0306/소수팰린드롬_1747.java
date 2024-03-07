package tjoon._0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수팰린드롬_1747 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int min = Integer.parseInt(br.readLine());

    if (min == 1) {
      System.out.println(2);
      return;
    }

    while (true) {
      if (isPrime(min) && isPalindrome(min)) {
        System.out.println(min);
        break;
      }

      min++;
    }

  }

  public static boolean isPrime(int num) {

    for (int i = 2; i <= (int) Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static boolean isPalindrome(int num) {

    StringBuilder sb = new StringBuilder();
    sb.append(num);
    int len = sb.toString().length();

    for (int i = 0; i < len / 2; i++) {
      char front = sb.charAt(i);
      char end = sb.charAt(len - i - 1);

      if (front != end) {
        return false;
      }
    }

    return true;
  }

}
