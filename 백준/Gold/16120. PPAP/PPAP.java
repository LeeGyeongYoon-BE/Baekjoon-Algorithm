import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stack.push(c);

            // 스택의 끝이 "PPAP"라면 "P"로 축약
            if (stack.size() >= 4) {
                int n = stack.size();
                if (stack.get(n - 1) == 'P' &&
                        stack.get(n - 2) == 'A' &&
                        stack.get(n - 3) == 'P' &&
                        stack.get(n - 4) == 'P') {

                    // "PPAP" 패턴 제거하고 "P" 추가
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push('P');
                } // if
            } // if
        } // for

        if (stack.size() == 1 && stack.pop() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        } // if ~ else

        br.close();
    } // main
} // class
