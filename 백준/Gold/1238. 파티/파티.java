import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int city;
		int time;
		
		public Node(int city, int time) {
			super();
			this.city = city;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}
	
	static List<Node>[] graph, reverse_graph;
	static int N, M, X;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// input start
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 	// 도시 및 학생
		M = Integer.parseInt(st.nextToken()); 	// 경로 수
		X = Integer.parseInt(st.nextToken()); 	// 파티 마을 번호
		
		graph = new ArrayList[N+1];
		reverse_graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverse_graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Node(B, T));
			reverse_graph[B].add(new Node(A, T));
		}
		// input end
		
		// X -> 각 마을 
		int[] dist1 = dijkstra(graph);
		
		// 뒤집어서 X <- 각 마
		int[] dist2 = dijkstra(reverse_graph);
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (dist1[i] + dist2[i] > answer) {
				answer = dist1[i] + dist2[i];
			}
		}
		
		System.out.println(answer);
	}
	
	static int[] dijkstra(List<Node>[] graph2) {
		
		int[] dist = new int[N+1];
		boolean[] isVisited = new boolean[N+1];
		
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
	
		dist[X] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (isVisited[now.city]) continue;
			isVisited[now.city] = true; 
			
			for (Node next : graph2[now.city]) {
				
				// !isVisited[next.city] &&  << 이거 필요하려
				if (dist[next.city] > dist[now.city] + next.time) {
					dist[next.city] = dist[now.city] + next.time;
					pq.offer(new Node(next.city, dist[next.city]));
				}
			}
		}
		
		return dist;
	}

}
