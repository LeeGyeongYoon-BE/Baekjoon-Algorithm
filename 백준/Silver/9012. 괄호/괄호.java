import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char[] input = br.readLine().toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            for (char ch : input) {
                if (ch == '('){
                    stack.offerLast('(');
                } else if (ch == ')'){
                    if (stack.isEmpty()){
                        isValid = false;
                        break;
                    }
                    stack.pollLast();
                }
            }
            if (!stack.isEmpty()){
                isValid = false;
            }
            System.out.println(isValid ? "YES" : "NO");

        }
    }
}