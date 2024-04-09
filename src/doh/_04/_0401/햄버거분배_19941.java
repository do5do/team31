package doh._04._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거분배_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        char[] table = new char[n];
        int start = -1;

        for (int i = 0; i < n; i++) {
            table[i] = line.charAt(i);
            if (start == -1 && table[i] == 'P') {
                start = i;
            }
        }

        if (start == -1) {
            System.out.println(0);
            System.exit(0);
        }

        int cnt = 0;
        for (int i = start; i < n; i++) {
            if (table[i] == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 0 && j < n && j != i && table[j] == 'H') {
                        cnt++;
                        table[j] = 'X';
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
