import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static TrieNode root;
    static Map<String, Integer> map;
    static StringBuilder answer;

    public static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        root = new TrieNode();
        map = new HashMap<>();
        answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            insertTrie(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (searchTrie(br.readLine())) answer++;
        }

        System.out.println(answer);
    }

    private static void insertTrie(String input) {
        TrieNode cur = root;

        for (Character c : input.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }

        cur.isEnd = true;
    }

    private static boolean searchTrie(String input) {
        TrieNode cur = root;

        for (Character c : input.toCharArray()) {
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                return false;
            }
        }

        return true;
    }
}