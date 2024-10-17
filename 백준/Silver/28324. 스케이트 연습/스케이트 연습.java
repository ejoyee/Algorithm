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
		int[] map = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 받기 끝 
		
		map[N-1] = 1;
		
		int result = map[N-1];
		for(int i = N-2; i >= 0; i--) {
			int tmp = map[i] + 1;
			
			if (map[i+1] + 1 >= map[i]) {
				//그대로유지 
			}else {
				map[i] = map[i+1] + 1;
			}
			
			result += map[i];
		}
		
		System.out.println(result);
		
	}
}