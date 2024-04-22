package tjoon._202404._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자고르기_2668 {

    static boolean[] visited;
    static int[] nums;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        nums = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < nums.length; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    private static void dfs(int cur, int target) {

        if (!visited[nums[cur]]) {
            visited[nums[cur]] = true;
            dfs(nums[cur], target);
            visited[nums[cur]] = false;
        }

        if (nums[cur] == target) {
            list.add(target);
        }
    }
}
