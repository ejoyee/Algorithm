import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str;

		while ((str = br.readLine()) != null) {

			int N = Integer.parseInt(str);
			String[] arr = new String[N];
			Trie trie = new Trie();
			double sum = 0;

			for (int i = 0; i < N; i++) {
				String word = br.readLine();
				trie.insert(word);
				arr[i] = word;
			}
			for (int i = 0; i < N; i++) {
				int cnt = trie.getCount(arr[i]);
				// System.out.print(cnt + " ");
				sum += cnt;
			}
			// System.out.println();

			bw.write(String.format("%.2f", sum / N) + "\n");
		}

		bw.flush();

	}

	static class Trie {

		private TrieNode rootNode;

		public Trie() {
			rootNode = new TrieNode();
		}

		public void insert(String word) {

			TrieNode thisNode = rootNode;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				thisNode = thisNode.getChildNodes().computeIfAbsent(ch, key -> new TrieNode());
			}

			thisNode.setIsLastChar(true);
		}

		public boolean contains(String word) {

			TrieNode thisNode = rootNode;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				thisNode = thisNode.getChildNodes().get(ch);

				if (thisNode == null)
					return false;
			}

			return thisNode.isLastChar();
		}

		public boolean delete(String word) {

			return delete(rootNode, word, 0);
		}

		public boolean delete(TrieNode thisNode, String word, int idx) {

			char ch = word.charAt(idx++);
			TrieNode childNode = thisNode.getChildNodes().get(ch);

			if (idx == word.length()) {

				if (childNode == null || !childNode.isLastChar())
					return false;

				childNode.setIsLastChar(false);

				if (childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(ch);

				return true;
			}

			if (delete(childNode, word, idx)) {
				if (childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(ch);
				return true;
			}
			return false;
		}

		public int getCount(String word) {

			int cnt = 1; // 첫 문자는 무조건 사용자가 직접 입력
			TrieNode thisNode = rootNode;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				thisNode = thisNode.getChildNodes().get(ch);

				// 아직 단어 검색이 완료되지 않았으면서
				// 특정 문자가 다른 단어의 마지막 문자이거나(isLastChar = true)
				// 현재 노드의 자식 노드가 1개 이상일 경우,
				// 사용자가 문자를 직접 입력한다. (cnt 증가)
				if (i < word.length() - 1 && (thisNode.isLastChar() || thisNode.getChildNodes().size() > 1))
					cnt++;
			}

			return cnt;
		}
	}

	static class TrieNode {

		private Map<Character, TrieNode> childNodes = new HashMap<>();
		private boolean isLastChar;

		public Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

		public void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		public boolean isLastChar() {
			return isLastChar;
		}

	}
}