package trie;

import java.util.List;

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

        trie.delete("apples");
        results = trie.searchByPrefix("app", 5);
        System.out.println("results = " + results);

        results = trie.searchByPrefix("app", 2);
        System.out.println("results = " + results);
    }
}
