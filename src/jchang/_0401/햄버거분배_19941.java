package jchang._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거분배_19941 {

  static int count = 0;
  static char[] table;
  static int n;
  static int k;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    String str = br.readLine();
    table = str.trim().toCharArray();
    eat();

    System.out.println(count);
  }

  private static void eat() {
    for (int i = 0; i < table.length; i++) {
      if (table[i] == 'P') {
        // 가장 왼쪽에 햄버거를 먹어야 한다..
        for (int j = Math.max(0, i - k); j <= Math.min(i + k, table.length - 1) ; j++) {
          if (table[j] == 'H') {
            count++;
            table[j] = 'X';
            break;
          }
        }

      }
    }
  }


}
