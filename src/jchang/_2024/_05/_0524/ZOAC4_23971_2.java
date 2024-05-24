package jchang._2024._05._0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC4_23971_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int hCeil = (int) Math.ceil((double) h / (n + 1));
    int wCeil = (int) Math.ceil((double) w / (m + 1));

    System.out.println(hCeil * wCeil);
  }
}
