class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] pronunciations = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            String tmp = word;

            for (String pronunciation : pronunciations) {
                tmp = tmp.replace(pronunciation, " ");
            }

            tmp = tmp.replace(" ", "");

            if (tmp.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}