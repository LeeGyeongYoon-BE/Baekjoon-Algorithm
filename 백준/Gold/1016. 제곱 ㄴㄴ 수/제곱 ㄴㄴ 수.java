import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] isNotSquareFree = new boolean[(int)(max - min + 1)];

        // 2부터 sqrt(max) 까지
        for (long i = 2; i * i <= max; i++) {
            long square = i * i;

            // min 이상인 첫 배수 구하기
            long start = (min % square == 0) ? min : (min / square + 1) * square;

            for (long j = start; j <= max; j += square) {
                isNotSquareFree[(int)(j - min)] = true;
            } // for - j
        } // for - i

        int count = 0;
        for (int i = 0; i < isNotSquareFree.length; i++) {
            if (!isNotSquareFree[i]) count++;
        } // for

        System.out.println(count);
    } // main
} // class
