package taehee._0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기사이클_1110 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = N;
    int cycle = 0;
    while (true) {
      int div = M / 10;
      int mod = M % 10;
      int sum = div + mod;
      M = mod * 10 + sum % 10;
      cycle++;
      if (N == M) {
        break;
      }
    }

    System.out.println(cycle);
  }
}
