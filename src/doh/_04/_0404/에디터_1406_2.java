package doh._04._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 에디터_1406_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base = br.readLine();
        int n = Integer.parseInt(br.readLine());

        List<Character> list = new LinkedList<>();
        for (int i = 0; i < base.length(); i++) {
            list.add(base.charAt(i));
        }

        ListIterator<Character> iterator = list.listIterator(list.size());

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            char prefix = cmd.charAt(0);

            if (prefix == 'P') {
                iterator.add(cmd.charAt(2));
            } else if (prefix == 'L') {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                }
            } else if (prefix == 'D') {
                if (iterator.hasNext()) {
                    iterator.next();
                }
            } else if (prefix == 'B') {
                if (iterator.hasPrevious()) {
                    iterator.previous(); // 맨 끝인 경우 nextIdx = size + 1을 가리키고 있어서 nextIdx-- 후 삭제한다.
                    iterator.remove();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character li : list) {
            sb.append(li);
        }
        System.out.println(sb);
    }
}
