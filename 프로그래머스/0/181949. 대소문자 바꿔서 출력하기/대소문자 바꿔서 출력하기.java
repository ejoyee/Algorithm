import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        // 65 - 90 대문자
        // 97 - 122 소문자
        
        // 32 차이
        
        String ans = "";
        
        for (int i = 0; i < a.length(); i++) {
            int tmp = (int) a.charAt(i);
            
            if (tmp >= 65 && tmp <= 90) {
                // 대문자
                ans += (char) (tmp + 32);
            }
            else {
                ans += (char) (tmp - 32);
            }
        }
        
        System.out.println(ans);
    }
}