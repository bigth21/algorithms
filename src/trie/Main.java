package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apples");
        trie.insert("applesauce");
        trie.insert("banana");

        List<String> results = trie.searchByPrefix("app", 5);
        System.out.println("results = " + results);

        results = trie.searchByPrefix("app", 3);
        System.out.println("results = " + results);
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    static class Trie {
        private final TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
            }
            current.isEndOfWord = true;
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return null;
                }
                current = current.children.get(c);
            }
            return current;
        }

        public List<String> searchByPrefix(String prefix, int limit) {
            List<String> results = new ArrayList<>();
            TrieNode node = searchPrefix(prefix);
            if (node != null) {
                dfs(node, new StringBuilder(prefix), results, limit);
            }
            return results;
        }

        private void dfs(TrieNode node, StringBuilder sb, List<String> results, int limit) {
            if (results.size() >= limit) {
                return;
            }

            if (node.isEndOfWord) {
                results.add(sb.toString());
            }

            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                sb.append(entry.getKey());
                dfs(entry.getValue(), sb, results, limit);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
