package crackingthecodinginterview.trie;

class WordSegmentationSolution {
    private TrieNode root = new TrieNode();

    public boolean wordBreak(String s, String[] wordDict) {
        buildTrie(wordDict);
        return searchSegmentedWord(s);
    }

    public boolean searchTrie(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.neighbours.containsKey(c))
                return false;
            curr = curr.neighbours.get(c);
        }
        return curr.isWordEnd;
    }

    private boolean searchSegmentedWord(String s){
        // Base case
        if (s.length() == 0)
            return true;

        for(int i=1; i <= s.length(); i++){
            if(searchTrie(s.substring(0,i)) && searchSegmentedWord(s.substring(i))){
                return true;
            }
        }
        return false;
    }

    public void buildTrie(String[] wordDict){
        TrieNode curr;
        for(String word : wordDict){
            curr = root;
            for(char c : word.toCharArray()){
                if(!curr.neighbours.containsKey(c)){
                    TrieNode node = new TrieNode(c);
                    curr.neighbours.put(c, node);
                }
                curr = curr.neighbours.get(c);
            }
            curr.isWordEnd = true;
        }
    }

    public static void main(String[] args) {
        String dictionary[]
                = { "mobile", "samsung",  "sam",  "sung", "ma",
                    "mango",  "icecream", "and",  "go",   "i",
                    "like",   "ice",      "cream" };

        WordSegmentationSolution sol = new WordSegmentationSolution();
        sol.buildTrie(dictionary);
        System.out.println(sol.searchTrie("samsung"));
        System.out.print(new WordSegmentationSolution().wordBreak("ilikesamsung", dictionary)
                         ? "Yes\n"
                         : "No\n");
        System.out.print(
                sol.wordBreak("iiiiiiii", dictionary) ? "Yes\n" : "No\n");
        System.out.print(new WordSegmentationSolution().wordBreak("", dictionary) ? "Yes\n"
                                             : "No\n");
        System.out.print(
                new WordSegmentationSolution().wordBreak("ilikelikeimangoiii", dictionary) ? "Yes\n"
                                                      : "No\n");
        System.out.print(sol.wordBreak("samsungandmango", dictionary)
                         ? "Yes\n"
                         : "No\n");
        System.out.print(new WordSegmentationSolution().wordBreak("samsungandmangok", dictionary)
                         ? "Yes\n"
                         : "No\n");
    }
}