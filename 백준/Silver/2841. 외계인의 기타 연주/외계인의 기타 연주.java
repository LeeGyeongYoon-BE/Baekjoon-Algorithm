import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Stack<Integer>> lines = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            lines.add(new Stack<>());
        } // for

        int count = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int nNum = Integer.parseInt(st.nextToken());
            int pNum = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = lines.get(nNum);

            while (!stack.isEmpty() && stack.peek() > pNum) {
                stack.pop();
                count++;
            } // while

            if (stack.isEmpty() || stack.peek() < pNum) {
                stack.push(pNum);
                count++;
            } // if
        } // while

        System.out.println(count);
        br.close();
    } // main
} // class
