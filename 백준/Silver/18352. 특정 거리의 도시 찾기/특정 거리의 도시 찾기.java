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

	static List<Integer>[] graph;

	static class Node implements Comparable<Node>{
		int city;
		int cost;

		public Node(int city, int cost) {
			super();
			this.city = city;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input start
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 도시
		int M = Integer.parseInt(st.nextToken()); // 경로
		int K = Integer.parseInt(st.nextToken()); // 거리 정보 (최저 경로가 이와 같아야 함)
		int X = Integer.parseInt(st.nextToken()); // 출발 도시

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[A].add(B);
		}
		// input end

		boolean[] isVisited = new boolean[N + 1];
		int[] dist = new int[N + 1];

		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);

		dist[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (isVisited[now.city])
				continue;
			isVisited[now.city] = true;

			for (int next : graph[now.city]) {

				if (dist[next] > dist[now.city] + 1) { // 이걸 해줘야 하려나?
					dist[next] = dist[now.city] + 1;
					pq.offer(new Node(next, dist[next]));
				}
			}
		}

		// 최소거리 출력
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
		    if (dist[i] == K) { sb.append(i).append('\n'); flag = true; }
		}
		if (!flag) sb.append(-1).append('\n');
		
		System.out.println(sb);
	}
}
