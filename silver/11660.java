import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i
        int[][] acc = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                acc[i][j] = acc[i -1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + arr[i][j];
            } // for - j
        } // for - i
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(m -- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            bw.write(acc[x2][y2] - acc[x1-1][y2]-acc[x2][y1-1] + acc[x1-1][y1-1] + "\n");
        } // while
        bw.flush();
        br.close();
    } // main
} // class
