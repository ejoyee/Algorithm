class Solution {
    public int solution(int balls, int share) {
        return comb(balls, share);
    }

    static int comb(int balls, int share) {
        if (balls == share || share == 0) return 1;
        return comb((balls - 1), (share - 1)) + comb(balls - 1, share);
    }
}