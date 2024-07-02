package doh._07._0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class 숫자고르기_2668 {
    static int[] nums;
    static boolean[] visited;
    static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n");
        for (Integer num : set) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int idx, int target) {
        if (nums[idx] == target) {
            set.add(target);
            return;
        }

        if (!visited[nums[idx]]) {
            visited[nums[idx]] = true;
            dfs(nums[idx], target);
            visited[nums[idx]] = false;
        }
    }
}
