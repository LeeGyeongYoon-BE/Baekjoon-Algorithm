import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    } // if
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    } // if
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    } // if
                } else {
                    left.push(c);
                } // if ~ else
            } // for

            StringBuilder sb = new StringBuilder();

            while (!left.isEmpty()) {
                right.push(left.pop());
            } // while
            while (!right.isEmpty()) {
                sb.append(right.pop());
            } // while

            System.out.println(sb);
        } // while
    } // main
} // class
