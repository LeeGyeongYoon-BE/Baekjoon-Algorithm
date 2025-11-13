import java.io.*;
import java.util.*;


public class Main {
    static boolean isPossible(int[] heights, int cutHeight, int thresholdHeight) {
        long sum = 0;
        for (int h : heights) {
            if (h > cutHeight) {
                sum += h - cutHeight;
            }
        }
        return sum >= thresholdHeight;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] h = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0, r = 1000000000, ans = -1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (isPossible(h, mid, m)){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);

    }
}
