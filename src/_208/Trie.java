package _208;
/**
 * 208. 实现 Trie (前缀树)
 * @author xm
 *
 */
public class Trie {
	private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode node = root;
    	for (int i = 0; i < word.length(); i++) {
			char curChar = word.charAt(i);
			if(!node.containsKey(curChar)) {
				node.put(curChar, new TrieNode());
			}
			node = node.get(curChar);
		}
    	node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode node = root;
    	for (int i = 0; i < word.length(); i++) {
    		char curChar = word.charAt(i);
			if(node.containsKey(curChar)) {
				node = node.get(curChar);
			}else {
				return false;
			}
		}
    	return node != null && node.isEnd();

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {//单词前缀
    	TrieNode node = root;
    	for (int i = 0; i < prefix.length(); i++) {
			char curChar = prefix.charAt(i);
			if(node.containsKey(curChar)) {
				node = node.get(curChar);
			}else {
				return false;
			}
		}
    	return node != null;

    }
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));

	}

}
