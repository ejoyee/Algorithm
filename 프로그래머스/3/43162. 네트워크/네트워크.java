class Solution {
    
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++){
            if (!visited[i]) {
                // 새로운 집단??을 찾아낼 시작점을 찾았으니 +1
                answer++;
                
                dfs(computers, i, n);
            }
        }
        
        return answer;
    }
    
    static void dfs(int[][] computers, int start, int n) {
        // 방문 체크 중요 (-> 방문됐다는 건 이미 카운팅된 집단 내에 있다는겨)
        visited[start] = true;
        
        for (int i = 0; i < n; i++){
            if (visited[i]) continue;
            
            // 연결되어 있으면 깊게 진입
            if (computers[start][i] == 1) {
                dfs(computers, i, n);
            }
        }
    }
    
}