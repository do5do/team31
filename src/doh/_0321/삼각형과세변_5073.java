package doh._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 삼각형과세변_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[3];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[0] = Integer.parseInt(st.nextToken());
            num[1] = Integer.parseInt(st.nextToken());
            num[2] = Integer.parseInt(st.nextToken());

            if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
                break;
            }

            Arrays.sort(num);

            if (num[2] >= num[0] + num[1]) {
                System.out.println("Invalid");
            } else if (num[0] == num[1] && num[1] == num[2]) {
                System.out.println("Equilateral");
            } else if (num[0] == num[1] || num[1] == num[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
