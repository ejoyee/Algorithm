class Solution {
    public int solution(int a, int b) {
                
        int g = gcd(a, b);
        b /= g; 

        // 2 제거
        while (b % 2 == 0) {
            b /= 2;
        }

        // 5 제거
        while (b % 5 == 0) {
            b /= 5;
        }

        if (b == 1) return 1;
        else return 2;
    }

    // 최대공약수 (검색함)
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
