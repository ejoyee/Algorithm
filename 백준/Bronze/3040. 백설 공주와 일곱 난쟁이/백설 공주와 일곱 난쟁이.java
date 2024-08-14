import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] nine = new int[9];
	
	static int[] seven = new int[7];
	
	static StringBuilder sb = new StringBuilder();
	
	
	static void real(int cnt, int start) {
		
		if(cnt == 7) {
			
			int tmp = 0;
			
			for(int i = 0; i < 7; i++) {
				tmp += seven[i];
			}
			
			if (tmp == 100) {
				
				for(int i = 0; i < 7; i++) {
					sb.append(seven[i]).append('\n');
				}
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			
			seven[cnt] = nine[i];
			real(cnt+1, i+1);
			
		}
		
	}
	
	
	
	
	//조합
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i<9; i++) {
			nine[i] = Integer.parseInt(br.readLine());			
		}
		
		
		real(0, 0);
		
		System.out.println(sb);
	}

}