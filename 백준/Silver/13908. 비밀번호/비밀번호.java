import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int n, m;
	
	static boolean[] num;
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작 
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if (m == 0) {
			result = (int) Math.pow(10, n);
			sb.append(result);
			System.out.println(sb);
			return;
		}
		
		num = new boolean[10];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			num[Integer.parseInt(st.nextToken())] = true;
		}
		// 입력 받기 
		
		pwd(0, 0);
		sb.append(result);
		System.out.println(sb);
	}
	
	static void pwd(int cnt, int condition) {
		
		if (cnt == n) {
			if (condition == m) {
				result++;
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			
			if (num[i]) {
				
				num[i] = false;
				pwd(cnt + 1, condition + 1);
				num[i] = true;
				
			}
			else {
				pwd(cnt+1, condition);
			}
			
		}
		
	}
	
}