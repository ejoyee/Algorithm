import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    
    static String N;    
    static int nLen;
    static int K;
    static Integer[] kArr;
    static int result = 0;

    // 깊이 우선 탐색 함수
    public static void dfs(int depth, int currentNum) {
        // 최대 자릿수까지 도달했을 때
        if (depth > nLen) {
            return;
        }

        // 현재 숫자가 유효한 경우 결과 갱신
        if (depth > 0 && currentNum <= Integer.parseInt(N)) {
            result = Math.max(result, currentNum); // 더 큰 값으로 갱신
        }

        // 다음 숫자를 생성하기 위해 재귀 호출
        for (int i = 0; i < K; i++) { // 큰 숫자부터 탐색
            int nextNum = currentNum * 10 + kArr[i];
            if (nextNum <= Integer.parseInt(N)) {
                dfs(depth + 1, nextNum); // 다음 자리로 이동
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.next(); // 목표 숫자 N
        nLen = N.length(); // N의 자리 수
        K = sc.nextInt(); // K의 원소 개수

        kArr = new Integer[K];
        for (int i = 0; i < K; i++) {
            kArr[i] = sc.nextInt(); // K의 원소들을 배열에 저장
        }

        // K 배열을 내림차순으로 정렬
        Arrays.sort(kArr, Comparator.reverseOrder());

        // DFS 탐색 시작 (초기 currentNum은 각 숫자)
        for (int i = 0; i < K; i++) {
            if (kArr[i] <= Integer.parseInt(N)) {
                dfs(1, kArr[i]); // 각 숫자를 시작점으로 DFS 호출
            }
        }

        // 결과 출력
        System.out.println(result);
        sc.close();
    }
}
