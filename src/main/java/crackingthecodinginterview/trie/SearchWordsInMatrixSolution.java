package crackingthecodinginterview.trie;

import java.util.HashSet;


public class SearchWordsInMatrixSolution {
    TrieNode root = new TrieNode();

    private void addWord(String word){
        if(word == null || word.length() == 0)
            throw new IllegalArgumentException("Input is valid");
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

    public HashSet<String> wordSearch(char[][] wordMatrix, String[] wordsToSearch){
        if(wordMatrix == null || wordMatrix.length == 0 || wordMatrix[0].length == 0)
            throw new IllegalArgumentException("Input is valid");

        buildTrie(wordsToSearch);
        HashSet<String> result = new HashSet<>();
        for(int row = 0; row < wordMatrix.length; row++){
            for(int col = 0; col < wordMatrix[0].length; col++){
                searchWordPattern(result, wordMatrix, row, col, root, "");
            }
        }

        return result;
    }

    private void buildTrie(String[] wordsToSearch) {
        for(String word : wordsToSearch){
            addWord(word);
        }
    }

    private void searchWordPattern(HashSet<String> result, char[][] wordMatrix, int row, int col, TrieNode curr, String prefix){
        if(!isCellWithinMatrixBoundary(wordMatrix, row, col)
           || wordMatrix[row][col] == '#'
           || !curr.neighbours.containsKey(wordMatrix[row][col])) {
            return;
        }

        curr = curr.neighbours.get(wordMatrix[row][col]);
        if(curr.isWordEnd){
            result.add(prefix + curr.c);
            return;
        }
        wordMatrix[row][col] = '#'; // mark visited
        //DFS in 4 direction
        searchWordPattern(result, wordMatrix, row + 1, col, curr, prefix + curr.c);
        searchWordPattern(result, wordMatrix, row - 1, col, curr, prefix + curr.c);
        searchWordPattern(result, wordMatrix, row, col + 1, curr, prefix + curr.c);
        searchWordPattern(result, wordMatrix, row, col - 1, curr, prefix + curr.c);
        wordMatrix[row][col] = curr.c; // unmark visited
    }

    private boolean isCellWithinMatrixBoundary(char[][] wordMatrix, int row, int col){
        return row >= 0 && row < wordMatrix.length && col >= 0 && col < wordMatrix[0].length;
    }

    public static void main(String[] args) {
        char[][] wordMatrix = {
                {'a','b','c','d'},
                {'i','d','a','t'}
        };

        String[] wordsToSearch = new String[]{"cat", "aid"};
        SearchWordsInMatrixSolution sol = new SearchWordsInMatrixSolution();
        HashSet<String> result = sol.wordSearch(wordMatrix, wordsToSearch);
        System.out.println(result);
    }
}
