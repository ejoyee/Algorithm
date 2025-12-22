import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // phone_book 1 - 1,000,000
        // number 1 - 20
        // no.1 : 트라이?
        // no.2 : 그냥 다 쪼개서 hashmap?
        
        // 어떤 번호 자체가 다른 번호읭 접두어일 경우 false 출력
        // String, Integer
        // 본인 자체만 map에 넣고, 넣기 전에 for문 돌면서 있는지 없는지 체크
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (String number : phone_book){
            hm.put(number, 1);
        }
        
        for (String number : phone_book) {
            for (int i = 0; i < number.length(); i++){
                if (hm.containsKey(number.substring(0, i))){
                    return false;
                }
            }
        }
        
        return answer;
    }
}