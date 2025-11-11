// 방향 그래프(DAG, Directed Acyclic Graph)에서 사용
// 간선 (u → v)가 존재하면 u가 v보다 먼저 나오도록 정렬
// 순서가 중요한 작업이나 의존성을 표현할 때 유용
// 예시: 강의 수강 순서, 빌드 순서, 작업 처리 순서 등

// BFS 기반 (Kahn's Algorithm)
// 집입 차수 0인 노드를 큐에 넣고 제거하며 순서 결정
import java.util.*;

public class TopologicalSortBFS {
    public static void topologicalSort(int n, List<Integer>[] graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.add(i);
        } // for

        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " "); // 출력 또는 저장
            for(int next : graph[node]) {
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            } // for
        } // while
    } // topologicalSort
} // class

// DFS 기반
// DFS 후 스택에 쌓은 뒤, 역순으로 출력
import java.util.*;

public class TopologicalSortDFS {
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void dfs(int node, List<Integer>[] graph) {
        visited[node] = true;
        for(int next : graph[node]) {
            if(!visited[next]) dfs(next, graph);
        } // for
        stack.push(node); // 모든 자식 방문 후 현재 노드 push
    } // dfs

    public static void topologicalSort(int n, List<Integer>[] graph) {
        visited = new boolean[n];
        stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(!visited[i]) dfs(i, graph);
        } // for
        while(!stack.isEmpty()) System.out.print(stack.pop() + " ");
    } // topologicalSort
} // class
