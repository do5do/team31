package doh._04._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자고르기_2668 {
    static int n;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int a : answer) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int target) {
        if (nums[idx] == target) {
            answer.add(target);
            return;
        }

        if (!visited[nums[idx]]) {
            visited[nums[idx]] = true;
            dfs(nums[idx], target);
            visited[nums[idx]] = false;
        }
    }
}
