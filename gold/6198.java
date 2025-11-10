import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long count = 0; // 결과가 int 범위를 넘을 수 있으므로 long
        
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            
            // 자신보다 낮거나 같은 빌딩은 볼 수 없음 → pop
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            
            // 스택에 남아 있는 빌딩들은 모두 현재 빌딩보다 높음 → 볼 수 있는 빌딩 개수
            count += stack.size();
            
            // 현재 빌딩을 스택에 추가
            stack.push(height);
        }
        
        System.out.println(count);
    }
}
