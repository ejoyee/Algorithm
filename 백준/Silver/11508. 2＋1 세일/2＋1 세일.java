import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int result = 0;
		int cnt = 0;
		for (int i = N-1; i >=0; i--) {
			cnt++;
			if (cnt == 3) {
				cnt = 0;
				continue;
			}else {
				result += arr[i];
			}
			
		}
		
		sb.append(result);
		System.out.println(sb);
		
		
	}

	
	
}