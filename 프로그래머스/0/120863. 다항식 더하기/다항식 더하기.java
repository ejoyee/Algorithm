import java.util.*;

class Solution {
    public String solution(String polynomial) {
        
        StringBuilder sb = new StringBuilder();
        
        String answer = "";
        String[] tmp = polynomial.split(" \\+ ");
        
        int x = 0;
        int n = 0;
        
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].contains("x")) {
                if (tmp[i].equals("x")) x += 1;
                else {
                    String t = tmp[i].substring(0, tmp[i].length()-1);
                    System.out.println("t : " + t);
                    x += Integer.parseInt(t);
                }
            }
            
            else {
                n += Integer.parseInt(tmp[i]);
            }
        }
        
        if (x != 0) {
            if (x == 1) sb.append("x");
            else sb.append(x).append("x");
        }

        if (n != 0) {
            if (sb.length() > 0) sb.append(" + ");
            sb.append(n);
        }

        return sb.toString();
    }
}