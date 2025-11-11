import java.io.*;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS(2, 1); // 소수, 해당 소수의 자릿수
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int number, int jarisu) {
        if (jarisu == N) {
            // 소수이면 출력
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }
        for (int i = 1; i <= 9; i++){
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(number * 10 + i)) {
                DFS(number * 10 + i, jarisu + 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                // i가 약수
                return false;
            }
        }
        return true;
    }
}