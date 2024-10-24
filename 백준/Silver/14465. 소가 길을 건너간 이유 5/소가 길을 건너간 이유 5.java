import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//횡단보도 수 
		int K = Integer.parseInt(st.nextToken());	//연속보장수
		int B = Integer.parseInt(st.nextToken());	//고장난신호등수
		
		int[] map = new int[N+1];
		
		for (int b = 0; b < B; b++) {
			int idx = Integer.parseInt(br.readLine());
			map[idx] = 1;
		}
		// 입력 받기 끝
		
		int sum = 0;
		for (int i = 1; i <= K; i++) {
			sum += map[i];
		}
		
		int min = sum;
		for (int i = K+1; i <= N; i++) {
			sum += map[i] - map[i-K];
			min = Math.min(sum, min);
		}
		
		System.out.println(min);
		
	}
	
}