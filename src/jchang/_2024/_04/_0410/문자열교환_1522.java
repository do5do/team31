package jchang._2024._04._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환_1522 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] chars = br.readLine().toCharArray();

    int aTotalCount = 0;

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == 'a') {
        aTotalCount++;
      }
    }

    int min = aTotalCount;
    for (int i = 0; i < chars.length; i++) {
      int bCount = 0;
      for (int j = i; j < aTotalCount + i; j++) {
        if (chars[j % chars.length] == 'b') {
          bCount++;
        }
      }
      min = Math.min(bCount, min);
    }

    System.out.println(min);


  }
}




