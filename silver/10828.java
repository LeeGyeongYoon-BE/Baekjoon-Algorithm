import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        while (N-->0){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (order.equals("pop")){
                if (!stack.isEmpty()){
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }

            } else if (order.equals("size")){
                sb.append(stack.size()).append("\n");
            } else if (order.equals("empty")){
                if (stack.isEmpty()){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (order.equals("top")){
                if (stack.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }

            }

        } // while

        br.close();
        System.out.println(sb.toString());
    } // main
} // class
