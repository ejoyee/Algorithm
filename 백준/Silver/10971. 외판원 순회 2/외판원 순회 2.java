import java.util.Scanner;

public class Main {
	
	static int[][] W;
	static int N;
	static boolean[] visited;
	static long result = Integer.MAX_VALUE;
	
	
	
	static void dfs(int start, long cost, int now, int vNum) {
		
		if (vNum == N) {
			if (W[now][start] > 0) {
				result = Math.min(result, (cost+W[now][start]));
			}
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (start == i) continue;
			if (W[now][i] > 0 && !visited[i]) {
				visited[i] = true;
				dfs(start, cost+W[now][i], i, vNum+1);
				visited[i] = false;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				W[i][j] = sc.nextInt();
			}
		}
		
		for (int i =1; i <= N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			dfs(i, 0, i, 1);
		}
		
		System.out.println(result);
	}

}
