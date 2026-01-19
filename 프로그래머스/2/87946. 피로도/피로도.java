class Solution {
    
    static boolean[] isVisited;
    static int size;
    static int[][] list;
    static int maxNum = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        size = dungeons.length;
        list = dungeons;
        isVisited = new boolean[size];
        
        dfs(k, 0);
        
        answer = maxNum;
        return answer;
    }
    
    
    static void dfs (int curK, int cnt) {
        
        if (curK >= 0) {
            maxNum = Math.max(cnt, maxNum);
        }
        
        for (int i = 0; i < size; i++) {
            if (isVisited[i]) continue;
            
            if (curK >= list[i][0]) {
                
                isVisited[i] = true;
                dfs (curK-list[i][1], cnt+1);
                
                isVisited[i] = false;
                
            } 
        }
    }
}