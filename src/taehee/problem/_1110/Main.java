package taehee.problem._1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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
