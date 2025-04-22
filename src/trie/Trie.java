package trie;

import java.util.*;

public class Trie {
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

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEndOfWord;
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

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (!node.isEndOfWord)
                return false;
            node.isEndOfWord = false;
            return node.children.isEmpty();
        }

        char ch = word.charAt(index);
        if (!node.children.containsKey(ch))
            return false;

        boolean shouldDelete = delete(node.children.get(ch), word, index + 1);
        if (shouldDelete) {
            node.children.remove(ch);
            return node.children.isEmpty() && !node.isEndOfWord;
        }

        return false;
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        //        Map<Character, TrieNode> children = new TreeMap<>(); // TreeMap ensures lexicographical order
        boolean isEndOfWord = false;
    }
}
