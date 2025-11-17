import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] cmds = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            Deque<String> dq = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                dq.offerLast(st.nextToken());
            }
            boolean isFlipped = false;
            boolean isValid = true;
            for (char cmd : cmds) {
                if (cmd == 'D'){
                    if (dq.isEmpty()){
                        isValid = false;
                        break;
                    }
                    if (isFlipped){
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                } else {
                    isFlipped = !isFlipped;
                }
            }
            if (isValid) {
                StringBuilder sb = new StringBuilder();
                while(!dq.isEmpty()){
                    sb.append(isFlipped ? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()){
                        sb.append(",");
                    }
                }
                System.out.println("[" + sb + "]");
            } else {
                System.out.println("error");
            }

        }
    }
}