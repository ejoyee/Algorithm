import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int V;
	static int[] parents;
	
	static void make() {
		
		parents = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parents[i] = -1; // 음수는 부모 없는 상태
		}	// Arrays.fill(parents, -1); 로 대체해도 됨
	}
	
	
	static int findSet(int a) {
		
		if (parents[a] < 0) return a;
		
		return parents[a] = findSet(parents[a]);	// path 압축
		// 집합의 대표자를 자신의 부모로 변경 : 패스 압축
		
	}
	
	
	static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;
		
		// 집합의 킈기에 따라 붙이도록 처리 가능 !! << 이 부분에서 하면 됨
		// 아래의 코드는 그냥 편의상 왼쪽(a집합)에 오른쪽(b집합)을 붙인 거기 때문에
		// 집합의 크기에 따라 붙이게끔 츄라이 해볼 것
		parents[aRoot] += parents[bRoot];	// 집합 크기 관리 (나중에 절대값을 사용하면 집합의 크기가 됨)
		parents[bRoot] = aRoot;
		// 이 두 과정의 순서 바뀌면 절대 안 됨~~ 
		return true;
		
	}
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		// 양수만 나오면 모르겠지만
		// 음수가 있거나, 아니면 실수할 거 같으면 ...~~
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		int E = sc.nextInt();
		
		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		
		Arrays.sort(edges); // 간선의 가중치 기준 오름차순 정렬
		
		make();	// 모든 정점을 분리집합으로 .. (단위 서로 소 집합 <트리> 생성)
		
		int cnt = 0;
		int cost = 0;
		
		for (Edge edge : edges) {
			if (union(edge.start, edge.end)) {
				cost += edge.weight;
				if (++cnt == V-1) break; // 최소 신장 트리 완성 ! 
			}
		}
		
		System.out.println(cost);
		
	}
	
}