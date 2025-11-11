// 깊이 우선 탐색은 그래프나 트리에서 한 방향으로 깊게 들어가며 탐색하는 알고리즘
// 재귀 또는 스택(Stack)을 사용
// 방문한 정점은 재방문 방지 위해 체크 필요

// 1. 시작 정점에서 방문 표시
// 2. 방문하지 않은 인접 정점을 재귀적으로 방문
// 3. 더 이상 방문할 정점이 없으면 이전 정점으로 되돌아감
// 4. 모든 정점을 방문할 때까지 반복

예시 그래프
    1
   / \
  2   3
 / \
4   5

DFS(1) 순서: 1 → 2 → 4 → 5 → 3

// 재귀 방식
void dfs(int v, boolean[] visited, List<Integer>[] graph) {
    visited[v] = true;
    System.out.print(v + " "); // 방문 처리
  
    for (int next : graph[v]) {
        if (!visited[next]) {
            dfs(next, visited, graph);
        } // if
    } // for
} // dfs

// 스택 방식
void dfs(int start, List<Integer>[] graph) {
    boolean[] visited = new boolean[graph.length];
    Stack<Integer> stack = new Stack<>();
    stack.push(start);

    while (!stack.isEmpty()) {
        int v = stack.pop();
        if (!visited[v]) {
            visited[v] = true;
            System.out.print(v + " ");
            for (int next : graph[v]) {
                if (!visited[next]) stack.push(next);
            } // for
        } // if
    } // while
} // dfs
