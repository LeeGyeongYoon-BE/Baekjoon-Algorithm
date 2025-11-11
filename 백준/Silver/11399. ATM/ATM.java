import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        int[] S = new int[N+1];
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        } // for

        for (int i = 1; i <= N; i++) {
            int idx = i;
            int value = A[i];
            for (int j = i - 1; j > 0; j--) {
                if (A[j] < A[i]) {
                    idx = j + 1;
                    break;
                } // if
                if (j == 1) {
                    idx = 1;
                } // if
            } // for - j
            for (int k = i; k > idx; k--){
                A[k] = A[k-1];
            } // for
            A[idx] = value;
        } // for - i

        S[1] = A[1];
        for (int i = 2; i <= N; i++) {
            S[i] = S[i - 1] + A[i];
        } // for

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += S[i];
        } // for

        System.out.println(ans);

        br.close();
    } // main
} // class