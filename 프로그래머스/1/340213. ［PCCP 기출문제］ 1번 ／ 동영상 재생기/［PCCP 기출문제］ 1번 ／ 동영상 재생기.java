class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // prev : 10초 전으로 이동 (10초 미만일 땐 영상 처음으로)
        // next : 10초 후로 이동 (남은 시간이 10초 미만일 땐 마지막 위치로 = 동영상 길이)
        // 건너뛰기 (op_start <= 현재 위치 <= op_end)
        
        // 반복문
        // 1. 건너뛰기 검증 후 이동한 뒤에 명령어 수행
        // 2. 명령어 수행
        
        int lenSec = Integer.parseInt(video_len.substring(0, 2)) * 60
                    + Integer.parseInt(video_len.substring(3, pos.length()));
        
        int posSec = Integer.parseInt(pos.substring(0, 2)) * 60
                    + Integer.parseInt(pos.substring(3, pos.length()));
            
        // System.out.println("posSec : " + posSec);
        
        int opStSec = Integer.parseInt(op_start.substring(0, 2)) * 60
                    + Integer.parseInt(op_start.substring(3, pos.length()));
        
        int opEnSec = Integer.parseInt(op_end.substring(0, 2)) * 60
                    + Integer.parseInt(op_end.substring(3, pos.length()));
        
        
        
        for (int i = 0; i < commands.length; i++) {
            
            // 건너뛰기 범위인지 체크
            if (posSec >= opStSec && posSec <= opEnSec ) {
                posSec = opEnSec;
            }
            
            if (commands[i].equals("next")) {
                
                if (posSec + 10 > lenSec) posSec = lenSec;
                else posSec += 10;
                
            }
            else {
                if (posSec-10 < 0) posSec = 0;
                else posSec -= 10;
            }
            
        }
        
        // 건너뛰기 범위인지 체크
            if (posSec >= opStSec && posSec <= opEnSec ) {
                posSec = opEnSec;
            }
        
        
        int ansMin = posSec / 60;
        int ansSec = posSec % 60;
        
        answer += (Integer.toString(ansMin).length() < 2) ? ("0" + Integer.toString(ansMin)) : Integer.toString(ansMin);
        answer += ":";
        answer += (Integer.toString(ansSec).length() < 2) ? ("0" + Integer.toString(ansSec)) : Integer.toString(ansSec);
        
        
        return answer;
    }
}