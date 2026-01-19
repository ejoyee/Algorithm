import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] isVisited;
    static int num;
    
    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;
        num = n;
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++){
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            
            isVisited = new boolean[n+1];
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            int result = dfs (v1, v1, v2);
            result = Math.abs(result-(num-result));
            
            answer = Math.min(answer, result);
        }
                
        return answer;
    }
    
    static int dfs (int cur, int v1, int v2) {
        
        isVisited[cur] = true;
        int cnt = 1;
        
        for (int i = 0; i < graph[cur].size(); i++){
            
            int next = graph[cur].get(i);
            if (v1 == cur && next == v2 || cur == v2 && next == v1) continue;
            if (isVisited[next]) continue;
            
            cnt += dfs(next, v1, v2);
        }
        
        return cnt;
    }
}