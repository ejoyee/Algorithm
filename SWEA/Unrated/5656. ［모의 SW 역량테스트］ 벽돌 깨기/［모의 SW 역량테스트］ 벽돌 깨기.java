import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	static int N, W, H;
	static int[][] map;
	
	static int[] selected;
	
	static class Block{
		int r;
		int c;
		int n;
		
		public Block(int r, int c, int n) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			// 초기화
			result = Integer.MAX_VALUE;
			
			// 입력 받기 시작
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			selected = new int[N]; 
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 받기 끝 
			
			select(0);
			sb.append('#').append(t).append(' ').append(result).append('\n');
			
			
		}
		System.out.println(sb);
	}
	
	static void select(int cnt) {
		
		if (cnt == N) {			
			// 함수 호출
			block();
			return;
		}
		
		for (int i = 0; i < W; i++) {
			selected[cnt] = i;
			select(cnt + 1);
		}
	}
	
	static void block() {
		
		// 배열 복사
		int[][] tmp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		// 배열 복사 끝
		
		for (int i = 0; i < N; i++) {
			
			// 벽돌이 있는 첫 위치 찾기
			int sc = selected[i];
			int sr = 0;
			for (sr = 0; sr <= H; sr++) {
				if (sr == H) break;
				if (tmp[sr][sc] != 0) {
					break;
				}
			}
			if (sr == H) return;	// 벽돌 없으면  return
			
			Queue<Block> q = new ArrayDeque<>();
			q.add(new Block(sr, sc, tmp[sr][sc]));
			
			while(!q.isEmpty()) {
				
				Block cur = q.poll();
				int cr = cur.r;
				int cc = cur.c;
				
				int range = cur.n - 1;
				
				for (int d = -range; d <= range; d++) {
					int nr = cr + d;
					int nc = cc + d;
					
					if (nr >= 0 && nr < H && tmp[nr][cc] != 0) {
						q.add(new Block(nr, cc, tmp[nr][cc]));
						tmp[nr][cc] = 0;
					}
					if (nc >= 0 && nc < W && tmp[cr][nc] != 0) {
						q.add(new Block(cr, nc, tmp[cr][nc]));
						tmp[cr][nc] = 0;
					}
				}
			} // 돌면서 터뜨리기
			
//			System.out.println("=============터뜨린 후============");
//			for (int j = 0; j < H; j++) {
//				for (int k = 0; k < W; k++) {
//					System.out.print(tmp[j][k] + " ");
//				}
//				System.out.println();
//			}
			
			// 내리기
			for (int j = 0; j < W; j++) {
				int input[] = new int[H];
				int cnt = 0;
				for (int k = 0; k < H; k++) {
					if (tmp[k][j] != 0) {
						input[cnt] = tmp[k][j];
						tmp[k][j] = 0;
						cnt++;
					}
				}
				for (int l = 0; l < cnt; l++) {
					tmp[H-cnt+l][j] = input[l];
				}
			}
//			System.out.println("=============내린 후===========");
//			for (int j = 0; j < H; j++) {
//				for (int k = 0; k < W; k++) {
//					System.out.print(tmp[j][k] + " ");
//				}
//				System.out.println();
//			}
			
			int cnt = 0;
			// 벽돌 수
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					if (tmp[j][k] != 0) {
						cnt++;
					}
				}
			}
			
			result = Math.min(cnt, result);
			
		}
		
	}
}