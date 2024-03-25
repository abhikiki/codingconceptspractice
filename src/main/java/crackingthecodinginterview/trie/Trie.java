package crackingthecodinginterview.trie;

import java.util.HashMap;
import java.util.HashSet;

class TrieNode{
    char c;
    boolean isWordEnd;
    HashMap<Character, TrieNode> neighbours = new HashMap<>();// neighbours

    public TrieNode(){}
    public TrieNode(char c){
        this.c = c;
    }
}
public class Trie {
    private TrieNode root = new TrieNode();

    //O(K) where K= length of word
    public void addWord(final String word){
        if(word == null || word.length() == 0)
            throw new IllegalArgumentException("invalid input");
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.neighbours.containsKey(c)){
                TrieNode node = new TrieNode(c);
                curr.neighbours.put(c, node);
            }
            curr = curr.neighbours.get(c);
        }
        curr.isWordEnd = true;
    }

    //O(K) where K= length of word
    public boolean search(final String word){
        if(word == null || word.length() == 0)
            throw new IllegalArgumentException("invalid input");
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.neighbours.containsKey(c)){
                return false;
            } else{
                curr = curr.neighbours.get(c);
            }
        }
        return curr.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0)
            throw new IllegalArgumentException("invalid input");
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            if(!curr.neighbours.containsKey(c)){
                return false;
            } else{
                curr = curr.neighbours.get(c);
            }
        }
        return !curr.neighbours.isEmpty();
    }

    public HashSet<String> findAllWordsStartingWithGivenPrefix(final String prefix) {
        if(prefix == null || prefix.length() == 0)
            throw new IllegalArgumentException("invalid input");
        TrieNode curr = root;
        HashSet<String> hset = new HashSet<>();
        for(char c : prefix.toCharArray()){
            if(!curr.neighbours.containsKey(c)){
                return hset;
            } else{
                curr = curr.neighbours.get(c);
            }
        }
        accumulateAllWords(hset, curr, prefix,"");
        return hset;
    }

    private  void accumulateAllWords(
            final HashSet<String> hset,
            final TrieNode root,
            final String prefix,
            final String suffix) {

        if(root.isWordEnd)
            hset.add(prefix + suffix);
        for(TrieNode neighbor: root.neighbours.values()){
            accumulateAllWords(hset, neighbor, prefix, suffix + neighbor.c);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("abhishek");
        trie.addWord("abhikiki");
        trie.addWord("baklol");
        System.out.println(trie.search("abhishek"));
        System.out.println(trie.search("abhisk"));
        System.out.println(trie.search("baklol"));
        System.out.println(trie.startsWith("baklol"));
        System.out.println(trie.findAllWordsStartingWithGivenPrefix("abhi"));
    }
}
