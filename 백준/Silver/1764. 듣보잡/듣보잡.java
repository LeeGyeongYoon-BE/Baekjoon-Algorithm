import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람 저장
        HashSet<String> unheard = new HashSet<>();

        for (int i = 0; i < n; i++) {
            unheard.add(br.readLine());
        }

        // 교집합 저장할 리스트
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }

        // 사전순 정렬
        Collections.sort(result);

        // 출력
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}
