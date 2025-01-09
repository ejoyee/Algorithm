import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();	
	static int K;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// input start
		K = Integer.parseInt(br.readLine());
		// input end
		
		char[] binary = Integer.toBinaryString(K+1).toCharArray();
		
		for (int i = 1; i < binary.length; i++) {
			if(binary[i] == '0') sb.append('4');
			else sb.append('7');
		}
		
		System.out.println(sb);
		
	}
}