package jchang._2024._04._0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가희와키워드_22233 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String str = br.readLine().trim();
      String[] blog = str.split(",");
      for (int j = 0; j < blog.length; j++) {
        set.remove(blog[j]);
      }
      sb.append(set.size()).append("\n");
    }
    System.out.println(sb);
  }
}
