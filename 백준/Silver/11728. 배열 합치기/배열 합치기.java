import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N + M];
        int indexA = 0;
        int indexB = 0;
        int indexAnswer = 0;
        while (indexA < N && indexB < M) {
            if (a[indexA] < b[indexB]){
                ans[indexAnswer++] = a[indexA++];
            } else {
                ans[indexAnswer++] = b[indexB++];
            }
        }
        while (indexA < N) {
            ans[indexAnswer++] = a[indexA++];
        }
        while (indexB < M) {
            ans[indexAnswer++] = b[indexB++];
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int x : ans){
            bw.write(x + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
