package doh._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 집합_11723 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node node = new Node();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            if ("add".equals(cmd)) {
                node.add(num);
            } else if ("check".equals(cmd)) {
                node.check(num);
            } else if ("remove".equals(cmd)) {
                node.remove(num);
            } else if ("toggle".equals(cmd)) {
                node.toggle(num);
            } else if ("all".equals(cmd)) {
                node.all();
            } else { // empty
                node.empty();
            }
        }

        System.out.println(sb);
    }

    static class Node {
        Set<Integer> set = new HashSet<>();

        void add(int num) {
            set.add(num);
        }

        void check(int num) {
            if (set.contains(num)) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }

        void remove(int num) {
            set.remove(num);
        }

        void toggle(int num) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        void all() {
            set = new HashSet<>();
            for (int i = 1; i <= 20; i++) {
                set.add(i);
            }
//            set = new HashSet<>(IntStream.range(1, 21).boxed().collect(Collectors.toList()));
        }

        void empty() {
            set.clear();
        }
    }
}
