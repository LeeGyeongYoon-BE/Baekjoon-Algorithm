import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Meeting {
    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    int start;
    int end;
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1.end == o2.end){
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int cnt = 0, ended = 0;
        for (int i = 0; i < N; i++){
            if (ended <= meetings[i].start){
                cnt++;
                ended = meetings[i].end;
            }
        }
        System.out.println(cnt);
    }
}
