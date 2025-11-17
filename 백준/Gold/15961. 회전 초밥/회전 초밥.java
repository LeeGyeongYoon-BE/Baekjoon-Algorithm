import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] dish = new int[N];
        for (int i = 0; i < N; i++){
            dish[i] = Integer.parseInt(br.readLine());
        }
        int[] dishCount = new int[D+1];
        int kind = 0;
        for (int i = 0; i < K-1; i++){
            if (dishCount[dish[i]]++ == 0){
                kind++;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++){
            if (dishCount[dish[(i+K-1) % N]]++ == 0){
                kind++;
            }
            ans = Math.max(ans, kind+(dishCount[C] == 0 ? 1 : 0));
            if (--dishCount[dish[i]] == 0){
                kind--;
            }
        }
        System.out.println(ans);
    }
}