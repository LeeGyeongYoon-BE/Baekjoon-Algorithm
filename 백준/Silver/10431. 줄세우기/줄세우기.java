import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] kids = new int[20];
            for (int i = 0; i < 20; i++) {
                kids[i] = Integer.parseInt(st.nextToken());
            } // for

            int count = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = i; j < 20; j++) {
                    if (kids[i] > kids[j]) {
                        count++;
                    } // if
                } // for - j
            } // for - i

            System.out.println(num + " " + count);

        } // while
        br.close();
    } // main
} // class