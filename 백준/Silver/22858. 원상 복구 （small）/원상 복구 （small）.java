import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;
		
		// 입력 받기 시작 
		// N :카드 수, K : 셔플 횟수 
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] order = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			order[i] = Integer.parseInt(st2.nextToken());
		}
		// 입력 받기 끝 
		
		
		// 셔플 복구 
		for (int i = 0; i < K; i++) {
			int[] tmp = new int[N+1];
			for (int j = 1; j <= N; j++) {
				tmp[order[j]] = arr[j];
			}
			arr = tmp;
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(' ');
		}
		
		System.out.println(sb);
		
	}

}