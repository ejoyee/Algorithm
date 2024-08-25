import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	static int H;
	static int W;
	
	static int x;
	static int y;
	
	static char[][] map;
	
	static int dir = 0;
	static char[] dirMark = {'^', 'v', '<', '>'};
	
	// 상하좌우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	
	
	// nx나 ny 범위 내에 있는
	static boolean isIn(int nx, int ny) {
		if (nx >= 0 && nx < W && ny >= 0 && ny < H) {
			return true;
		}else {
			return false;
		}
	}
	
	static void move() {
		map[y][x] = dirMark[dir];
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if (isIn(nx, ny) && map[ny][nx] == '.') {
			map[ny][nx] = map[y][x];
			map[y][x] = '.';
			x = nx;
			y = ny;
		}
	}
	
	// main start
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			// H : 높이, W : 너
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					
					// 전차 위치 빛 방향 기록 
					if (map[i][j] == '^') {
						dir = 0;
						y = i;
						x = j;
					}else if (map[i][j] == 'v') {
						dir = 1;
						y = i;
						x = j;						
					}else if (map[i][j] == '<') {
						dir = 2;
						y = i;
						x = j;
					}else if (map[i][j] == '>') {
						dir = 3;
						y = i;
						x = j;
					}

				}
			}	// map input end
			
			
			// 명령어 입력 받기
			int N = Integer.parseInt(br.readLine());
			String cmdStr = br.readLine();
			
			for(int i = 0; i < N; i++) {
				
				char cmd = cmdStr.charAt(i);
				
				if (cmd == 'U') {
					dir = 0;
					move();
				}
				else if (cmd == 'D') {
					dir = 1;
					move();
				}
				else if (cmd == 'L') {
					dir = 2;
					move();
				}
				else if (cmd == 'R') {
					dir = 3;
					move();
				}else if (cmd == 'S') {
					
					int nx = x;
					int ny = y;
					
					while(isIn(nx, ny)) {
						 
						nx += dx[dir];
						ny += dy[dir];
						
						if (isIn(nx, ny)) {
							
							char tmp = map[ny][nx];
							if (tmp == '*') {
								map[ny][nx] = '.';
								break;
							}
							else if (tmp == '#') {
								break;
							}
							
						}else {
							// 범위 벗어나면 
							break;
						}
					}	// shoot while end
				}	// shoot else if end
			}	// cnd for end
			
			sb.append('#').append(t).append(' ');
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			
		}	// testcase end
		System.out.println(sb);
	}	// main end
}	// class end
