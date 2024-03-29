package doh._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int cnt = 1;
        while (queue.size() > 1) {
            int cur = queue.poll();
            if (cnt % 2 == 0) {
                queue.offer(cur);
            }
            cnt++;
        }

        System.out.println(queue.peek());
    }
}
