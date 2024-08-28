import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	static boolean[][] graph;
	
	static int start;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			
			graph = new boolean[100+1][100+1];
			
			// 입력 받기 시작 
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()) / 2;
			start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from][to] = true;
				
			}
			// 입력 받기 끝
			
			
			int result = bfs(start);
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			
		}	// testcase end
		System.out.println(sb);
	}	// main end
	
	static int bfs(int start) {
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[100+1];
		
		visited[start] = true;
		q.offer(start);
		
		int ans = 0;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			ans = 0;
			
			while(--size >= 0) {
				
				int cur = q.poll();
				ans = Math.max(cur, ans);
				
				for(int i = 1; i <= 100; i++) {
					if (!graph[cur][i] || visited[i]) continue;
					
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
		return ans;
		
	}
	
}	// class end