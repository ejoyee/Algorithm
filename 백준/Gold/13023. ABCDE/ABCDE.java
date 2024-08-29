import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	
	static List<Integer>[] friends;
	static boolean[] isVisited;
	
	static void dfs(int cnt, int cur) {
		
		if (cnt == 4) {
			
			sb.append(1);
			System.out.println(sb);

			System.exit(0);
			
		}
		
		isVisited[cur] = true;
		
		for (int num : friends[cur]) {
			
			if (!isVisited[num]) {
				isVisited[num] = true;
				dfs(cnt+1, num);
				isVisited[num] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		friends = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			friends[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends[a].add(b);
			friends[b].add(a);
		}
		// 입력 받기 끝 
		
		for (int i = 0; i < N; i ++) {
			
			isVisited = new boolean[N];
			dfs(0, i);
		}
		
		sb.append(0);
		System.out.println(sb);
		
	}	//main end
}	// class end