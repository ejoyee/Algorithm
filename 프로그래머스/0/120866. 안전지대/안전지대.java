class Solution {
    public int solution(int[][] board) {
        
        // 8방 (상하좌우 왼쪽위 오른쪽위 왼쪽아래 오른쪽아래)
        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        // 지뢰 1
        // 지뢰 x 0
        
        int n = board.length;
        int answer = n * n;
        
        boolean[][] danger = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    
                    danger[i][j] = true;
                    
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (isIn(nr, nc, n)) {
                            danger[nr][nc] = true;
                        }
                        else continue;
                    }
                    
                }
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if (danger[i][j]) answer--;
            }
        }
        
        return answer;
    }
    
    static boolean isIn (int r, int c, int n){
        if (r >= 0 && r < n && c >= 0 && c < n) return true;
        else return false;
    }
}