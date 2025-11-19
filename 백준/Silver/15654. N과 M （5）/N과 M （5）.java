import java.io.*;
import java.util.*;

class Main {
    public static int[] numbers;
    public static int[] output;
    public static boolean[] check;

    public static int n;
    public static int m;
    public static void perm(int depth){
        if (depth == m){
            for (int i = 0; i < m; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++){
            if (!check[i]){
                check[i] = true;
                output[depth] = numbers[i];
                perm(depth + 1);
                check[i] = false;
            }
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        output = new int[m];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        perm(0);

    }

}