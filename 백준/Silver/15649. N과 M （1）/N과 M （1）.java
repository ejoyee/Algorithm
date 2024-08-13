import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static boolean[] isSelected;
	static int[] arr;
	
	static void dfs(int cnt){
		
		if (cnt == M) {
			for(int i = 0; i < M; i++){
				
				System.out.print(arr[i] +" ");
				
			}
			System.out.println();
			return;
		}else {
			
			for (int i = 1; i <= N; i++) {
				if (isSelected[i]) continue;
				else {
					arr[cnt] = i;
					isSelected[i] = true;
					dfs(cnt + 1);
					isSelected[i] = false;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N 범위
		// M 수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N+1];
		arr = new int[M];
		
		dfs(0);
		
		
	}

}