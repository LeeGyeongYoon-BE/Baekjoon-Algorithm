import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = N;

        for (long p = 2; p <= Math.sqrt(N); p++) {
            if (N % p == 0){
                result = result - result / p;
                while (N % p == 0){
                    N = N / p;
                } // while
            } // if
        } // for

        if (N > 1) {
            result = result - result / N;
        } // if

        System.out.println(result);

        br.close();
    } // main
} // class
