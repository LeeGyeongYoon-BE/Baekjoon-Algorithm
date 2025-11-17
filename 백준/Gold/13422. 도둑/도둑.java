import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static int getRangeSum(int[] acc, int l, int r){
        if (l <= r){
            return acc[r] - acc[l-1];
        }
        return acc[acc.length-1]-acc[l-1] + acc[r];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] money = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }

            int[] accMoney = new int[N+1];
            for(int i = 1; i <= N; i++){
                accMoney[i] = accMoney[i-1] + money[i];
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (getRangeSum(accMoney, i, (i+M-2)%N+1) < K){
                    ans++;
                }
            }
            if (N == M){
                ans = Math.min(1, ans);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
