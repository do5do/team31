package tjoon._202404._0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ListofUniqueNumbers_13144 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        Set<Integer> set = new HashSet<>();
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                for (int j = start; j < i; j++) {
                    start++;
                    count += (i - j);

                    if (nums[j] == nums[i]) {
                        break;
                    }

                    set.remove(nums[j]);
                }
            } else {
                set.add(nums[i]);
            }
        }

        for (int i = start; i < n; i++) {
            count += (n - i);
        }

        System.out.println(count);

    }
}
