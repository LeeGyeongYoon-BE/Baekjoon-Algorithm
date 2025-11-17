import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Main {
    static long howmanyPass(long givenTime, int[] timePerPass){
        long count = 0;
        for (int time : timePerPass) {
            count += givenTime / time;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] timePerPass = new int[N];
        for (int i = 0; i < N; i++) {
            timePerPass[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0;
        long l = 1;
        long r = (long)Arrays.stream(timePerPass).min().getAsInt() * M;
        while(l <= r){
            long m = (l+r)/2;
            if (howmanyPass(m, timePerPass) >= M) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
    }
}
