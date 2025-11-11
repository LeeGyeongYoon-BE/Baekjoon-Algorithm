import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int deleteNode;
    static int leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;

        // 트리 구성
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i; // 루트 노드
            } else {
                tree[parent].add(i); // 부모 -> 자식
            } // if ~ else
        } // for

        deleteNode = Integer.parseInt(br.readLine());

        // 루트가 삭제되면 리프 노드 없음
        if (root == deleteNode) {
            System.out.println(0);
        } else {
            dfs(root); // DFS로 남은 리프 노드 탐색
            System.out.println(leafCount);
        } // if ~ else
    } // main

    static void dfs(int node) {
        boolean isLeaf = true; // 현재 노드가 리프인지 확인

        for (int child : tree[node]) {
            if (child == deleteNode) continue; // 삭제 노드이면 탐색하지 않음
            dfs(child);
            isLeaf = false; // 자식이 있으면 리프 아님
        } // for

        if (isLeaf) leafCount++; // 자식 없으면 리프 노드 카운트
    } // dfs
} // class
