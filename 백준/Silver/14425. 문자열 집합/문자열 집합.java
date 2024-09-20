import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, 0);
		}
		
		int result = 0;
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) result++;
		}
		
		System.out.println(result);
		
		
		
	}
}