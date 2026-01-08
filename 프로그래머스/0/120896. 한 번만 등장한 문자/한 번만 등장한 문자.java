import java.util.*;

class Solution {
    public String solution(String s) {
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 1) {
                list.add((char)(i + 'a'));
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
