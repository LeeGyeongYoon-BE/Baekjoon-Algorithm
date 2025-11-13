import java.io.*;
import java.util.*;


public class Main {
    static int findNearestValue(int[] arr, int leftIndex, int rightIndex, int findValue){
        int nearestValue = arr[leftIndex];
        int nearestDiff = Math.abs(findValue - nearestValue);
        int l = leftIndex + 1, r = rightIndex;
        while (l <= r){
            int m = (l + r) / 2;
            int diff = Math.abs(findValue - arr[m]);
            if (diff < nearestDiff){
                nearestValue = arr[m];
                nearestDiff = diff;
            }
            if (arr[m] < findValue){
                l = m + 1;
            } else if (arr[m] > findValue){
                r = m - 1;
            } else {
                return findValue;
            }
        }
        return nearestValue;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ansAbs = Math.abs(arr[0] + arr[1]);
        int ans1 = arr[0];
        int ans2 = arr[1];
        for (int i = 0; i < n - 1; i++) {
            int pairValue = findNearestValue(arr, i + 1, n - 1, -arr[i]);
            int sumAbs = Math.abs(arr[i] + pairValue);
            if (ansAbs > sumAbs){
                ansAbs = sumAbs;
                ans1 = arr[i];
                ans2 = pairValue;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
