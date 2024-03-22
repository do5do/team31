package jchang._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집_2292 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    if ( N == 1) {
      System.out.println(1);
      System.exit(0);
    }
    int total = 1;
    int count = 1;
    int six = 6;
    while (true) {
      total += six;
      count++;
      if (N <= total) {
        System.out.println(count);
        break;
      }
      six += 6;

    }
  }
}
