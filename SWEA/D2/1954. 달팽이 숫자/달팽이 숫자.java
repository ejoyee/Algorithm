import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
			// 우 하 좌 상
			int[] dlY = {0, 1, 0, -1};
			int[] dlX = {1, 0, -1, 0};
			
			int y=0;
			int x=0;
			
			int dir = 0;
			
			int count = 1;
			arr[y][x] = count++;
 			
			
			while(count <= N*N) {
				
				int dy = y + dlY[dir];
				int dx = x + dlX[dir];
				
				if (dy >= 0 && dx >= 0 && dy < N && dx < N && arr[dy][dx] == 0) {
					arr[dy][dx] = count++;
					y = dy;
					x = dx;
				}
				else {
					dir = (dir + 1) % 4;
					
				}
			}
			
			System.out.println("#" + t);
			for (int i = 0; i<N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				
				System.out.println();
			}
			
			
			
		} // testcase for end
	} // main end
} //class end
