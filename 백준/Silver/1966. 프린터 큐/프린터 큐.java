import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static class Docs {
		int num; 
		int w;
		
		public Docs(int num, int w) {
			super();
			this.num = num;
			this.w = w;
		}
	}
	
	static Queue<Docs> q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			int ans = 0;
			
			// input start
			q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 중요도 리스
			List<Integer> list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				
				int tmp = Integer.parseInt(st.nextToken());
				
				q.add(new Docs(i, tmp));
				list.add(tmp);
			}
			// input end
			
			// 중요도 내림차순 정렬
			Collections.sort(list, Collections.reverseOrder());
			
			int idx = 0;
			
			while (!q.isEmpty()) {
				
				Docs cur = q.poll();
				
				if (cur.w != list.get(idx)) {
					q.add(cur);
				}
				else {
					ans++;
					idx++;
					
					if (cur.num == M) break;
				}
				
			}
			
			sb.append(ans).append('\n');
			
		}
		
		System.out.println(sb);
	}

}
