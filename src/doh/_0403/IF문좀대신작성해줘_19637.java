package doh._0403;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IF문좀대신작성해줘_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int left = 0;
            int right = n - 1;
            String answer = nodes[n - 1].name;

            while (left < right) {
                int mid = (left + right) / 2;

                if (nodes[mid].value >= num) {
                    answer = nodes[mid].name;
                    right = mid;
                } else if (nodes[mid].value < num) {
                    left = mid + 1;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static class Node {
        String name;
        int value;

        public Node(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}
