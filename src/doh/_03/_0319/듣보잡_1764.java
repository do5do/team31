package doh._03._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 듣보잡_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> see = new TreeSet<>();
        Set<String> hear = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            see.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            hear.add(br.readLine());
        }

        see.retainAll(hear);
        System.out.println(see.size());
        for (String a : see) {
            System.out.println(a);
        }
    }
}
