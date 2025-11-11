import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positive.add(num);
            } else if (num == 1) {
                oneCount++;
            } else if (num == 0) {
                zeroCount++;
            } else {
                negative.add(num);
            }
        }
        // 양수 내림차순
        Collections.sort(positive, Collections.reverseOrder());
        // 음수 오름차순
        Collections.sort(negative);

        int sum = 0;
        for (int i = 0; i < positive.size(); i += 2) {
            if (i + 1 < positive.size()) {
                sum += positive.get(i) * positive.get(i + 1);
            } else {
                sum += positive.get(i);
            }
        }

        for (int i = 0; i < negative.size(); i += 2) {
            if (i + 1 < negative.size()) {
                sum += negative.get(i) * negative.get(i + 1);
            } else {
                if (zeroCount > 0) {
                    zeroCount--;
                } else {
                    sum += negative.get(i);
                }
            }
        }

        sum += oneCount;
        System.out.println(sum);
    }
}