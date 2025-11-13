import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static long calcIntegerSqrt(long x){
        if (x == 0){
            return 0;
        }
        long l = 1, r = 1L << 32, sqrt = -1;  // << : 비트 연산자 : 1L << 32 == 2^32
        while(l <= r){
            long m = (l + r) / 2;
            if (m >= (x - 1) / m + 1){
                r = m - 1;
                sqrt = m;
            }
            else {
                l = m + 1;
            }
        }
        return sqrt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        System.out.println(calcIntegerSqrt(T));

    }
}
