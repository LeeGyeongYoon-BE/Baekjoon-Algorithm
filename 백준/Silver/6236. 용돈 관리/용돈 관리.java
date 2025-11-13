import java.io.*;
import java.util.*;


public class Main {
    static boolean isPossible(int[] useAmounts, int drawAmount, int maxDrawCount){
        int drawCount = 1;
        int currentAmount = drawAmount;
        for (int useAmount : useAmounts) {
            if (useAmount > drawAmount) {
                return false;
            }
            if (currentAmount < useAmount) {
                if (drawCount == maxDrawCount) {
                    return false;
                }
                drawCount++;
                currentAmount = drawAmount;
            }
            currentAmount -= useAmount;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] useAmounts = new int[n];
        for (int i = 0; i < n; i++) {
            useAmounts[i] = Integer.parseInt(br.readLine());
        }
        int l = 1, r = n*10000, ans = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if (isPossible(useAmounts, mid, m)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
