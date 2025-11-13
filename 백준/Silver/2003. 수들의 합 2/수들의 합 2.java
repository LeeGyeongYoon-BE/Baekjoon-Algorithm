import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int nextIndex = 0;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            while (currentSum < m && nextIndex < n){
                currentSum += arr[nextIndex++];
            }
            if (currentSum == m){
                ans++;
            }
            currentSum -= arr[i];
        }
        System.out.println(ans);

    }
}
