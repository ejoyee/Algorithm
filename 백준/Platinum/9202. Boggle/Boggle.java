import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int w, b;
    // 상하좌우 좌상 좌하 우상 우하
    static int dr[] = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int dc[] = {0, 0, -1, 1, -1, -1, 1, 1};

    static Trie trie;
    static char[][] grid;
    static boolean[][] visited;
    static Set<String> words;

    ;

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];  // 알파벳 A-Z (26개)
        boolean endOfWord = false;               // 단어의 끝 여부
    }

    static public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 단어 삽입
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'A';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.endOfWord = true;
        }

        // prefix 검사 : 해당 prefix로 시작하는 문자열이 있는지 확인
        public int startsWith(String prefix) {
            TrieNode node = root;

            for (char c : prefix.toCharArray()) {
                node = node.children[c - 'A'];
                if (node == null) {
                    return 0;
                }
            }
            if (node.endOfWord) return 2;
            else return 1;
        }
    }

    // 점수 채점
    static int getScore(String str) {
        int len = str.length();

        if (len <= 2) return 0;
        else if (len <= 4) return 1;
        else if (len <= 5) return 2;
        else if (len <= 6) return 3;
        else if (len <= 7) return 5;
        else return 11;
    }

    static void dfs(int r, int c, String cur) {

        int result = trie.startsWith(cur);

        if (result == 0) return;
        if (result == 2) {
            words.add(cur);
        }

        // return == 1
        if (cur.length() >= 8) return;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, cur+ grid[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        w = Integer.parseInt(br.readLine());
        trie = new Trie();

        for (int i = 0; i < w; i++) {
//            String tmp = br.readLine();
            trie.insert(br.readLine());
        }

        br.readLine();

        b = Integer.parseInt(br.readLine());
        for (int i = 0; i < b; i++) {
            if (i > 0) br.readLine();

            grid = new char[4][4];
            for (int j = 0; j < 4; j++) {
                String tmp = br.readLine();
                for (int k = 0; k < 4; k++) {
                    grid[j][k] = tmp.charAt(k);
                }
            }

            words = new HashSet<>();
            visited = new boolean[4][4];

            // 탐색
            for (int k = 0; k < 4; k++) {
                for (int l = 0; l < 4; l++) {
                    visited[k][l] = true;
                    dfs(k, l, "" + grid[k][l]);
                    visited[k][l] = false;
                }
            }

            // 3. 정답 출력
            List<String> list = new ArrayList<>(words);
            Collections.sort(list);
            int total = 0;
            int maxLen = 0;
            String maxStr = "";
            for(int e = 0; e < list.size(); e++){
                String cur = list.get(e);

                total += getScore(cur);

                if(maxLen < cur.length()){
                    maxLen = cur.length();
                    maxStr = cur;
                }
            }

            sb.append(total).append(' ').append(maxStr).append(' ').append(list.size()).append('\n');
        }

        System.out.println(sb);
    }

}
