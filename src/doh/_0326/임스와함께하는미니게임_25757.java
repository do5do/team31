package doh._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 임스와함께하는미니게임_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        map.put('Y', 2);
        map.put('F', 3);
        map.put('O', 4);

        int n = Integer.parseInt(st.nextToken());
        int maxNum = map.get(st.nextToken().charAt(0)) - 1; // 최대 인원수에서 본인 제외

        Set<String> total = new HashSet<>(); // 게임한 사람
        Set<String> names = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            if (!total.contains(name)) {
                names.add(name);
                total.add(name);

                if (names.size() == maxNum) {
                    answer++;
                    names.clear();
                }
            }
        }

        System.out.println(answer);
    }
}
