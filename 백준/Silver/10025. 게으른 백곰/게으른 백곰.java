import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static class Bucket{
        int g;
        int x;
        Bucket(int g, int x){
            this.g = g;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Bucket[] buckets = new Bucket[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            buckets[i] = new Bucket(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(buckets, (o1, o2) -> o1.x - o2.x);

        int nextIndex = 0;
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N && buckets[nextIndex].x - buckets[i].x <= 2* K){
                currentSum += buckets[nextIndex++].g;
            }
            maxSum = Math.max(maxSum, currentSum);
            currentSum -= buckets[i].g;
        }
        sb.append(maxSum);
        System.out.println(sb);
    }
}
