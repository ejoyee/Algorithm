import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	static int map[][];
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			// 입력 받기 시작
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] input = new int[N];
			switch (command) {
			case "up":
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						input[j] = map[j][i];
					}
					slide(input, i, 0, 0);
				}
				break;
			case "down":
				for (int i = 0; i < N; i++) {
					for (int j = N-1; j >= 0; j--) {
						input[N-j-1] = map[j][i];
					}
					slide(input, i, N-1, 1);
				}
				break;
			case "left":
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						input[j] = map[i][j];
					}
					slide(input, 0, i, 2);
				}
				break;
			case "right":
				for (int i = 0; i < N; i++) {
					for (int j = N-1; j >= 0; j--) {
						input[N-j-1] = map[i][j];
					}
					slide(input, N-1, i, 3);
				}
				break;
			default:
				break;
			}
			// 입력 받기 & 설정 끝
			
			
			// 출력 append
			sb.append('#').append(t).append('\n');
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			
		}	// testcase end
		System.out.println(sb);
	}	// main end
	
	
	
	static void slide (int[] list, int x, int y, int dir) {
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i = 0;i < list.length;i++) if(list[i] != 0) q.addLast(list[i]);
		
		
		int[] ret = new int[list.length];
		
		int count = 0;
		while(!q.isEmpty()) {
			if(q.size() == 1) {
				ret[count++] = q.pollFirst();
				break;
			}
			int tmp1 = q.pollFirst();
			int tmp2 = q.peekFirst();
			
			if(tmp1 == tmp2) {
				q.pollFirst();
				ret[count++] = 2*tmp1;
			} else {
				ret[count++] = tmp1;
			}
		} // while end
		
		for(;count < list.length;count++) ret[count] = 0;
		
		
		// 상일 때
		if (dir == 0) {
			for (int i = 0; i < N; i++) {
				map[i][x] = ret[i];
			}
		}
		// 하일 때
		else if (dir == 1) {
			for (int i = N-1; i >= 0; i--) {
				map[i][x] = ret[N-i-1];
			}
		}
		// 좌일 때
		else if (dir == 2) {
			for (int i = 0; i < N; i++) {
				map[y][i] = ret[i];
			}
		}
		// 우일 때
		else {
			for (int i = N-1; i >= 0; i--) {
				map[y][i] = ret[N-i-1];
			}
		}
	}
	
}	// class end