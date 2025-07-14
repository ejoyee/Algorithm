import java.io.*;
import java.util.*;

public class Main {

    // 완탐 : n x n 으로 모든 조합의 에너지를 전부 계산하면 O(n^2) -> 시간초과
    // 비트마스킹 필요
    // 비트마스킹 하면 자연수를 이진수로 변환한 후 이진수의 자릿수만큼만 반복 O(n * 20)
    // 비트마스킹 시 XOR 연산(현재 자릿수에서 0인 값과 1인 값)으로 에너지 계산
        // 1. 이진수의 자릿수만큼 반복
        // 2. i번째 자리수가 0인 자연수, 1인 자연수
        // 3. 각 개수와 현재 자릿수를 고려하여 얻을 수 있는 에너지 계산
        // 4. 모든 자릿수에서 에너지의 합을 반환

    static int n;
    static long ans;
    static int numbers[];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        numbers = new int[n];

        for(int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }

        // 이진수의 자릿수만큼 반복
        // n의 최대 값은 100만 (2의 20승)
        for(int bit = 0; bit <= 20; bit++){

            int cnt0 = 0; // 현재 자릿수의 비트가 0인 자연수 개수
            int cnt1 = 0; // 현재 자릿수의 비트가 1인 자연수 개수

            for (int i = 0; i < n; i++) {
                if ((numbers[i] & (1 << bit)) != 0) {
                    cnt1++;
                }
            }

            cnt0 = n - cnt1;  // 현재 비트가 0인 수의 개수
            long pairCount = (long) cnt0 * cnt1;
            long energy = pairCount * (1L << bit);  // 2^bit 만큼 에너지 발생
            ans += energy;

        }

        System.out.println(ans);
    }

}
