package jchang._2024._06._0612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가희와키워드_22233_2 {
  // 키워드 N개 (전부 다름)
  // 최대 10개 키워드 사용
  // 사용한 키워드는 삭제
  // 남은 키워드 수는?
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
      String[] blog = br.readLine().split(",");
      for (int j = 0; j < blog.length; j++) {
        set.remove(blog[j]);
      }

      sb.append(set.size()).append("\n");
    }

    System.out.println(sb);
  }
}
