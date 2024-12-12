import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w,  o.w);
		}
		
		
		
	}
	
	// N : 팀원의 수, V : 장소의 수, E : 도로의 수 
	static int N, V, E;
	
	static List<List<Node>> graph = new ArrayList<>();
	static int[] dist;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// input start
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] homes  = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			homes[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, l));
			graph.get(b).add(new Node(a, l));
			
		}
		// input end
		
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			dijkstra(homes[i]);
			result += dist[K] == Integer.MAX_VALUE ? -1 : dist[K];
			result += dist[C] == Integer.MAX_VALUE ? -1 : dist[C];
		}
		
		System.out.println(result);
	
	} // main end
	
	static void dijkstra(int start) {
		dist = new int[V + 1];
		isVisited= new boolean[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, dist[start]));
		
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			isVisited[cur.v] = true; 
			
			for (int i = 0; i < graph.get(cur.v).size(); i++) {
				Node next = graph.get(cur.v).get(i);
				
				if (isVisited[next.v] || dist[next.v]< dist[cur.v]+ next.w ) {
					continue;
				}
				
				dist[next.v]= dist[cur.v]+ next.w;
				pq.offer(new Node(next.v, dist[next.v]));
			}
			
		}
	}

} // class end