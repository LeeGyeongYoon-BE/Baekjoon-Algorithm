import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] expression = br.readLine().toCharArray();
        int[] value = new int[N];
        for (int i = 0; i < N; i++)
            value[i] = Integer.parseInt(br.readLine());

        double[] calc = new double[expression.length];
        int calcIndex = -1;
        for (char ch : expression) {
            if ('A' <= ch && ch <= 'Z') {
                calc[++calcIndex] = value[ch - 'A'];
            }
            else {
                double result = calc[calcIndex - 1];
                if (ch == '+') result += calc[calcIndex];
                else if (ch == '-') result -= calc[calcIndex];
                else if (ch == '*') result *= calc[calcIndex];
                else if (ch == '/') result /= calc[calcIndex];
                calc[--calcIndex] = result;
            }
        }
        System.out.printf("%.2f\n", calc[0]);
    } // main
} // class
