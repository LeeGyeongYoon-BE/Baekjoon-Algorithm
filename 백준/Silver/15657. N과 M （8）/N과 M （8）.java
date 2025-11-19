import java.io.*;
import java.util.*;

class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void print(int[] arr, int n){
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }

    public static void perm(int[] arr, int[] output, int depth, int n, int m, int start){
        if (depth == m){
            print(output, m);
            return;
        }
        for (int i = start; i < n; i++){
            output[depth] = arr[i];
            perm(arr, output, depth+1, n, m, i);
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        perm(numbers, new int[m], 0, n, m, 0);
        System.out.println(sb);
    }

}