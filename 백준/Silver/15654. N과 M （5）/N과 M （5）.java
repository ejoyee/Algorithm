import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] nArr;
	static boolean[] isSelected;
	static int[] arr;
	
	static void dfs(int cnt) {
		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			arr[cnt] = nArr[i];
			dfs(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nArr = new int[N];
		arr = new int[M];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArr);
		dfs(0);
		System.out.println(sb);
	}
}