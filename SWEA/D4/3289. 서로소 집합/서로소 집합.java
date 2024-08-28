import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int m;
	
	static int[] parents;
	
	static void make() {
		
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
	}
	
	static int findSet(int a) {
		
		if (a == parents[a]) return a;
		
		return parents[a] = findSet(parents[a]);
		
	}
	
	static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;	// 두 집합의 대표자가 같으면 이미 같은 집합이므로, 합집합 연산 불가

		// aRoot에 bRoot를 흡수
		// 대표자 - 대표자끼리 합치기
		parents[bRoot] = aRoot;
		return true;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			make();
			
			sb.append('#').append(t).append(' ');
			
			for (int i = 0; i < m; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				int cmd = Integer.parseInt(st.nextToken());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (cmd == 0) {
					
					union(a, b);
					
				}
				else if (cmd == 1) {
					
					if (findSet(a) == findSet(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
					
				}
				
			}
			
			sb.append('\n');
			
		}	// testcase end
		
		System.out.println(sb);
	}	// main end
}	// class end