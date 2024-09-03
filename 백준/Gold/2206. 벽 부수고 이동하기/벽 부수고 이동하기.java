import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static class Node{
        int r;
        int c;
        int flag;
        
        public Node(int r, int c, int flag) {
            super();
            this.r = r;
            this.c = c;
            this.flag = flag;
        }
    }
    
    
    static void bfs() {
        
        Queue<Node> q = new ArrayDeque<>();
        int isVisited[][][] = new int[N+1][M+1][2];
        
        isVisited[1][1][0] = 1;
        q.offer(new Node(1, 1, 0));
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            while(--size >= 0) {
                
                Node cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                int flag = cur.flag;
                
                if (r == N && c == M) {
                    System.out.println(isVisited[r][c][flag]);
                    return;
                }
                
                for (int i = 0; i < 4; i++) {
                    
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if (isIn(nr, nc)) {
                        
                        // 방문 체크 확인 nr nc 0, 1이 0보다 더 크면 
                    	if (isVisited[nr][nc][flag] > 0) continue;
                        
                        
                        // 지금이 벽이 아닐 때
                        if (map[r][c] == 0) {
                            // 벽을 뚫지 않은 경우
                            isVisited[nr][nc][flag] = isVisited[r][c][flag] + 1;
                            q.offer(new Node(nr, nc, flag));
                        }
                        
                        // 지금이 벽일 때 
                        else if (map[r][c] == 1) {
                            // 벽을 이미 한 번 뚫은 경우
                            if (flag == 1) continue;
                            
                            // 벽 안 뚫었을 때?
                            else if (flag == 0) {
                                isVisited[nr][nc][1] = isVisited[r][c][flag] + 1;
                                q.offer(new Node(nr, nc, 1));
                            }
                        }
                    }
                }
                
            }    // same breadth end
        }    // queue end
        
        // 만약 도착 N M까지 못 가면 -1
        if (isVisited[N][M][0] == 0 && isVisited[N][M][1] == 0) {
            System.out.println(-1);
            return;
        }
        
    }    // bfs end
    
    
    static boolean isIn(int nr, int nc) {
        if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) return true;
        else return false;
    }
    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 입력 받기 시작
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i+1][j+1] = str.charAt(j) - '0';
            }
        }
        // 입력 받기 끝
        
        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }
        
        bfs();
        
    }    // main end
}    // class end