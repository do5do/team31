package doh._07._0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 하늘에서별똥별이빗발친다_14658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        int[][] arr = new int[k][2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xSet.add(x);
            ySet.add(y);
            arr[i] = new int[] {x, y};
        }

        int cover = 0;
        for (int x : xSet) {
            for (int y : ySet) {
                int cnt = 0;
                for (int[] star : arr) {
                    // x ~ x + l, y ~ y + l
                    if (x <= star[0] && x + l >= star[0]
                            && y <= star[1] && y + l >= star[1]) {
                        cnt++;
                    }
                }

                cover = Math.max(cover, cnt);
            }
        }

        System.out.println(k - cover);
    }
}
