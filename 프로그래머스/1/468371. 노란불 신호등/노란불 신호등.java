class Solution {
    public int solution(int[][] signals) {
        // n개의 신호등
        // 초 노 빨
        // 1초부터 시작, 시작은 늘 초록불
        
        // 모든 신호등이 노란불 -> 정전
        
        // 노란불 숫자 최소공배수를 구하면 되는 건가?
        // 아예 불가능하면 -1?
        
        int limit = 1;

        // 모든 신호등의 전체 주기에 대한 최소공배수 계산
        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            limit = lcm(limit, cycle);
        }

        // 패턴이 한 번 반복될 때까지 확인
        for (int time = 1; time <= limit; time++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                int green = signal[0];
                int yellow = signal[1];
                int cycle = signal[0] + signal[1] + signal[2];

                // 현재 시간이 해당 신호등 주기에서 몇 번째 위치인지 확인
                int position = (time - 1) % cycle;

                // 노란불 구간이 아니라면 즉시 중단
                if (position < green || position >= green + yellow) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return time;
            }
        }

        return -1;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}