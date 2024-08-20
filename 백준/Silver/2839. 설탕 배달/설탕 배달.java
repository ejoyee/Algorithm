import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	
	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 5kg 3kg
		// 더 적은 개수의 봉지
		// 딱 안 떨어지면 -1
		
		int result = 0;
		
		if (N == 4 || N == 7) {
			result = -1;
		}
		
		else if (N % 5 == 0) {
			result =  N / 5;
		}
		
		else if (N % 5 == 1 || N % 5 == 3) {
			result = N / 5 + 1;
		}
		
		else if (N%5 == 2 || N%5 == 4) {
			result = N / 5 + 2;
		}
		
		
		sb.append(result);
		System.out.println(sb);
		
	} //main end
} //class end