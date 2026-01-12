class Solution {
    public int solution(String A, String B) {
        
        // 같으면 무조건
        if (A.equals(B)) return 0;

        String cur = A;
        int n = A.length();

        for (int i = 1; i <= n; i++) {
            
            // 오른쪽으로 한 칸 밀기
            cur = cur.charAt(n - 1) + cur.substring(0, n - 1);

            if (cur.equals(B)) {
                return i;
            }
        }

        return -1;
    }
}
