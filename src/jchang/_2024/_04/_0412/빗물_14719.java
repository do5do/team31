package jchang._2024._04._0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_14719 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());

    int[] world = new int[w];
    int max = 0;
    int maxIdx = -1;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < w; i++) {
      world[i] = Integer.parseInt(st.nextToken());
      if (world[i] > max) {
        max = world[i];
        maxIdx = i;
      }
    }

    if (maxIdx == -1) {
      System.out.println(0);
      System.exit(0);
    }

    int height = 0;
    int sum = 0;
    for (int i = 0; i < maxIdx; i++) {
      if (world[i] > height) {
        height = world[i];
      } else {
        sum += height - world[i];
      }
    }

    height = 0;
    for (int i = world.length - 1; i > maxIdx; i--) {
      if (world[i] > height) {
        height = world[i];
      } else {
        sum += height - world[i];
      }
    }

    System.out.println(sum);
  }
}
