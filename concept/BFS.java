// 너비 우선 탐색은 그래프나 트리에서 같은 깊이 레벨의 정점들을 먼저 탐색하는 알고리즘
// 큐(Queue)를 사용
// 방문한 정점은 재방문 방지 위해 체크 필요
// 최단 경로 탐색, 최단 거리 계산에 유용

// 1. 시작 정점을 방문하고 큐에 삽입
// 2. 큐에서 정점을 꺼내면서 방문 처리
// 3. 꺼낸 정점의 인접 정점 중 방문하지 않은 정점을 큐에 삽입
// 4. 큐가 빌 때까지 반복

예시 그래프
    1
   / \
  2   3
 / \
4   5

BFS(1) 순서: 1 → 2 → 3 → 4 → 5

void bfs(int start, List<Integer>[] graph) {
    boolean[] visited = new boolean[graph.length];
    Queue<Integer> queue = new LinkedList<>();
    
    queue.add(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int v = queue.poll();
        System.out.print(v + " "); // 방문 처리
        
        for (int next : graph[v]) {
            if (!visited[next]) {
                visited[next] = true;
                queue.add(next);
            } // if
        } // for
    } // while
} // bfs
