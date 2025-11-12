import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int X = Integer.parseInt(br.readLine());
        boolean[] exist = new boolean[10000001];
        for (int i = 0; i < N; i++) {
            exist[a[i]] = true;
        }
        int ans = 0;
        for (int i = 0; i <= (X-1)/2; i++) {
            if (i <= 1000000 && X-i <= 1000000) {
                ans += (exist[i] && exist[X-i]) ? 1 : 0;
            }
        }
        bw.write(ans+ "\n");
        bw.flush();
    }
}
