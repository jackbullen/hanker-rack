import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    static class TrieNode {
        TrieNode[] children;
        boolean endOfWord;

        TrieNode() {
            this.children = new TrieNode[26];
            this.endOfWord = false;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public boolean insert(String word) {
            TrieNode node = root;

            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char c = chars[i];
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                } else {
                    if (i == word.length() - 1) {
                        // Current word is prefix of previous
                        return true;
                    }
                }
                node = node.children[idx];
                if (node.endOfWord) {
                    // Previous is prefix of current word
                    return true;
                }
            }
            node.endOfWord = true;
            return false;
        }

        public void noPrefix(String[] words) {
            for (String word : words) {
                if (insert(word)) {
                    System.out.println("BAD SET");
                    System.out.println(word);
                    return;
                }
            }
            System.out.println("GOOD SET");
        }
    }

    public static void main(String[] args) {
        File file = new File("input.txt");
        try {

            Scanner scanner = new Scanner(file);

            int numWords = scanner.nextInt();
            scanner.nextLine();
            String[] words = new String[numWords];
            for (int i = 0; i < numWords; i++) {
                words[i] = scanner.nextLine();
            }

            Trie trie = new Trie();
            trie.noPrefix(words);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}