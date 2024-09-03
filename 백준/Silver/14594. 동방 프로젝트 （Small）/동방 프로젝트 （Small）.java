import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 또이 하이
	
	static int N, M;
	static int[] rooms;
	static int cnt;
	
	static void make() {
		rooms = new int[N];
		
		for (int i = 0; i < N; i++) {
			rooms[i] = -1;
		}
	}
	
	static void union(int a, int b) {
		
		int aP = findSet(a);
		int bP = findSet(b);
		
		if (aP==bP) return;
		
		
		rooms[b] = a;
		cnt--;
	}
	
	static int findSet(int a) {
		if (rooms[a] == -1) return a;
		return rooms[a] = findSet(rooms[a]);
	}

	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		cnt = N;
		
		make();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int tmp = a-1;
			int tmp2 = a;
			
			for (int j = 0; j < b-a; j++) {
				
				union(tmp, tmp2);
					tmp++;
					tmp2++;
				
				if (tmp2 == b) break;
			}
		}
		
		System.out.println(cnt);
		
	}
	

}