import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int[][] box;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int babytomato = 0;
    
    static class Point{
        int r;
        int c;
        
        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }
    
    static Queue<Point> q = new ArrayDeque<>();
    static boolean[][] isVisited;
    
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 입력 받기 시작  
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                
                if (box[i][j] == 0) babytomato++;
            }
        }
        // 입력 받기 
        
        isVisited = new boolean[N][M];
        
        // 1 익은 토마토 
        // 0 익지 않은 토마토
        // -1 빈 칸 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                	isVisited[i][j] = true;
                	q.offer(new Point(i, j));
                }
            }
        }
        
        // babytomato가 있다면
        if (babytomato > 0) {
        	bfs();
        }
        
        // bfs 탐색 후 남은 안 익은 토마토가 있다면 
        if (babytomato > 0) {
        	result = -1;
        	System.out.println(result);
        }else {
        	System.out.println(result);
        }
        
    }
    
    static void bfs () {

        
        int cnt = 0;
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            while(--size >= 0) {
                
                
                Point cur = q.poll();
                
                int r = cur.r;
                int c = cur.c;
                
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if (!isIn(nr, nc)) continue;
                    if (isVisited[nr][nc]) continue;
                    if (box[nr][nc] != 0) continue;
                    
                    box[nr][nc] = 1;
                    isVisited[nr][nc] = true;
                    q.offer(new Point(nr,nc));
                    babytomato--;
                }

            }    // level end
            cnt++;
            if (babytomato == 0) {
            	result = Math.max(result, cnt);
            	return;
            }
        }    // while isEmpty end
    }    // bfs end
    
    static boolean isIn(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
        else return false;
    }
    
    

}