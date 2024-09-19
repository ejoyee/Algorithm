import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] gamer = new int[N+1];
			for (int i = 1; i <= N; i++) {
				gamer[i] = Integer.parseInt(br.readLine());
				
			}
			
			
			boolean[] isVisited = new boolean[N+1];
			int cnt = 1;
			int num = gamer[1];
			isVisited[1] = true;
			
			while(true) {
				
				if (num == N) break;
				if (isVisited[gamer[num]]) break;
				
				num = gamer[num];
				cnt++;
				isVisited[num] = true;
				
			}
			
			if (num == N) {
				System.out.println(cnt);
			} else {
				System.out.println(0);
			}
			
		}
		
	}

}