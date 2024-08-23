import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	static int N;	// 고객 수
	static int[] x;	// 고객 i의 집 좌표 x
	static int[] y; // 고객 i의 집 좌표 y
	
	static boolean[] isVisited;
	
	static int minDist = Integer.MAX_VALUE;
	

	
	static void dfs(int cnt, int distSum, int cur) {
		
		if (distSum >= minDist) {
			return;
		}
		
		if (cnt == N) {
			// 마지막 곳에서부터 집까지의 거리를 더한 dist와 minDist 비교
			int dist = Math.abs(x[cur] - x[1]) + Math.abs(y[cur]-y[1]);
			minDist = Math.min(minDist, distSum + dist);
			return;
		}
		
		for (int i = 2; i < N+2; i++) {
			
			if (isVisited[i]) continue;
			
			isVisited[i] = true;
			int dist = Math.abs(x[cur] - x[i]) + Math.abs(y[cur]-y[i]);
			
			dfs(cnt+1, distSum+dist, i);
			isVisited[i] = false;
			
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			//초기화
			minDist = Integer.MAX_VALUE;
			
			// 입력 받기 시작
			N = Integer.parseInt(br.readLine());
			
			// idx = 0 : 회사, 1 : 집
			x = new int[N+2];
			y = new int[N+2];
			isVisited = new boolean[N+2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N+2; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			// 처음 dfs 부를 땐 cur에 회사 index
			isVisited[0] = true;
			dfs(0, 0, 0);
			
			sb.append('#').append(t).append(' ').append(minDist).append('\n');
			
		}
		
		System.out.println(sb);
		
	}

}