import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int[] zerodp;
	static int[] onedp;
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			zerodp = new int[41];
			onedp = new int[41];
			
			N = Integer.parseInt(br.readLine());
			
			zerodp[0] = 1;
			zerodp[1] = 0;
			onedp[1] = 1;
			onedp[0] = 0;
			
			for (int i = 2; i <= N; i++) {
				zerodp[i] = zerodp[i-1] + zerodp[i-2];
				onedp[i] = onedp[i-1] + onedp[i-2];
			}
			
			sb.append(zerodp[N]).append(' ').append(onedp[N]).append('\n');
		}
		
		System.out.println(sb);
		
	}	// main end
}	// class end