package doh._04._0403;

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
        int n = Integer.parseInt(st.nextToken()); // 키워드 개수
        int m = Integer.parseInt(st.nextToken()); // 글 수

        Set<String> keyword = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keyword.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] used = br.readLine().split(",");
            for (int j = 0; j < used.length; j++) {
                if (keyword.contains(used[j])) {
                    keyword.remove(used[j]);
                }
            }

            sb.append(keyword.size()).append("\n");
        }

        System.out.println(sb);
    }
}
