package jchang._2024._04._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기_1515 {

  static String str;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    str = br.readLine();

    int base = 1;
    int idx = 0;

    loop:
    while(idx < str.length()) {
      String baseString = String.valueOf(base);
      for (int i = 0; i < baseString.length(); i++) {
        if (str.charAt(idx) == baseString.charAt(i)) {
          idx++;
        }
        if (idx == str.length()) {
          break loop;
        }
      }
      base++;
    }

    System.out.println(base);
  }


}
