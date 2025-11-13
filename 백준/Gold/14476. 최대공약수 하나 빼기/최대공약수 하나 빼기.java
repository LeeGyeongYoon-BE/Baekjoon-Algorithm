import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽 GCD 배열
        int[] left = new int[N];
        left[0] = arr[0];
        for (int i = 1; i < N; i++) {
            left[i] = gcd(left[i - 1], arr[i]);
        }

        // 오른쪽 GCD 배열
        int[] right = new int[N];
        right[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            right[i] = gcd(right[i + 1], arr[i]);
        }

        int maxGCD = -1;
        int element = -1;

        for (int i = 0; i < N; i++) {
            int currentGCD;

            if (i == 0) {
                currentGCD = right[1];
            } else if (i == N - 1) {
                currentGCD = left[N - 2];
            } else {
                currentGCD = gcd(left[i - 1], right[i + 1]);
            }

            // 조건: currentGCD는 1보다 커야 하고, arr[i]의 약수가 아니어야 한다.
            if (currentGCD > 1 && arr[i] % currentGCD != 0 && currentGCD > maxGCD) {
                maxGCD = currentGCD;
                element = arr[i];
            }
        }

        if (maxGCD == -1) {
            System.out.println("-1");
        } else {
            System.out.println(maxGCD + " " + element);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
