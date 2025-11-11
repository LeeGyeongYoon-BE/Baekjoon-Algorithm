import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long l = 1;
        long r = (long)N*N;
        long ans = -1;
        while (l <= r) {
            long m = (l+r)/2;
            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(m / i, N);
            }
            if (count >= K){
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
    }
}
