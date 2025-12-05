import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;

    static void rec_func(int k){
        if (k == m + 1){
            for (int i = 1; i <= m; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int start = selected[k-1];
            if (start == 0){
                start = 1;
            }
            for (int cand = start; cand <= n; cand++){
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m+1];

        rec_func(1);
        System.out.println(sb);
    }
}
