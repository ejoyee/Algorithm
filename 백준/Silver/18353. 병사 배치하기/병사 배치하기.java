import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작 
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] lenArr = new int[N+1];
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 받기 끝 
		
		for (int i = 1; i <= N; i++) {
			
			lenArr[i] = 1;
			for (int j = i-1; j > 0; j--) {
				if (arr[j] > arr[i]) {
					lenArr[i] = Math.max(lenArr[j]+1, lenArr[i]);	// 뒤에 빠져야 할 애로 갱신될까 봐 최장 길이 구하려고
				}
			}
			
			result = Math.max(result, lenArr[i]);
		}
		
		System.out.println(N-result);
	}
}