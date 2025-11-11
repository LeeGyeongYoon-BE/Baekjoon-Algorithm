import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        } // for
        Arrays.sort(A);
        int count = 0;
        for (int k = 0; k < N; k++) {
            long find = A[k];
            int L = 0;
            int R = N - 1;
            while (L < R) {
                if (A[L] + A[R] == find) {
                    if (L != k && R != k){
                        count++;
                        break;
                    } else if (L == k) {
                        L++;
                    } else if (R == k){
                        R--;
                    }
                } else if (A[L] + A[R] > find) {
                    R--;
                } else {
                    L++;
                }
            } // while
        } // for

        System.out.println(count);
    } // main
} // class