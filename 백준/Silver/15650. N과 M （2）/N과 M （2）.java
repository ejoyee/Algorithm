import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static int[] arr;
	
	static StringBuilder sb = new StringBuilder();
	
	
	static void combi(int cnt, int start) {
		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = start; i <= N; i++) {
			
			arr[cnt] = i;
			combi(cnt+1, i+1);
			
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		combi(0, 1);
		System.out.println(sb);
		
	}

}