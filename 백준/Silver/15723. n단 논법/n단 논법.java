import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static boolean[][] graph;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// N : 2~26
		N = Integer.parseInt(br.readLine());
		graph = new boolean[26][26];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			char S = str.charAt(0);
			char O = str.charAt(str.length()-1);

			graph[S - 'a'][O - 'a'] = true;

		}


		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String str = br.readLine();

			char S = str.charAt(0);
			char O = str.charAt(str.length()-1);
			
			if (bfs(S-'a', O-'a')) {
				sb.append('T').append('\n');
			}else {
				sb.append('F').append('\n');
			}

		}
		
		System.out.println(sb);

	}

	static boolean bfs(int start, int end) {

		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[26];
		
		q.offer(start);
		isVisited[start] = true;
		while(!q.isEmpty()) {
			
			int s = q.poll();
			
			if (s == end) {
				return true;
			}
			
			for (int i = 0; i < 26; i++) {
				if (graph[s][i] && !isVisited[i]) {
					isVisited[i] = true;
					q.offer(i);
				}
			}
			
			
		}
		return false;

	}

}