import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bruteForce(new int[m], 0);
        System.out.println(sb);
    }

    public static void bruteForce(int[] arr, int depth){
        if (depth == m){
            for (int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++){
            arr[depth] = i;
            bruteForce(arr, depth + 1);
        }
    }

}
