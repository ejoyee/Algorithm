import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        
        Arrays.sort(spell);
        // String str = Arrays.toString(spell);
        String str = String.join("", spell);
        // System.out.println(str);

        
        for (int i = 0; i < dic.length; i++){
            char[] c = dic[i].toCharArray();
    
            Arrays.sort(c);
            String tmp = new String(c);
            // System.out.println(tmp);
            if (tmp.equals(str)) return 1;
            
        }
        
        return 2;
    }
}