import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            String str = br.readLine();
            List<Character> list = new LinkedList<>();
            int idx = 0;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if ( c == '<') {
                    idx -= idx == 0 ? 0 : 1;
                } else if ( c == '>') {
                    idx += idx < list.size()? 1 : 0;
                } else if ( c == '-') {
                    if (idx > 0) list.remove(--idx);
                } else {
                    list.add(idx++, c);
                }
            } // for - j

            for (char c : list) sb.append(c);
            sb.append("\n");
        } // for - i

        System.out.println(sb.toString());
        br.close();
    } // main
} // class