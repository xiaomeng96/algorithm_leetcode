package _212;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 * @author xm
 *
 */
//前缀节点
class TrieNode{
	public TrieNode[] children;
	public String word;
	TrieNode(){//初始化
		children = new TrieNode[26];
		word = null;
	}
}
//前缀树
class Trie{
	public TrieNode root;
	Trie(){
		root = new TrieNode();
	}
	//将单词插入到前缀树中
	public void insert(String word) {
		TrieNode node = root;
		char[] array = word.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if(node.children[array[i] - 'a'] == null) {
				node.children[array[i] - 'a'] = new TrieNode();
			}
			node = node.children[array[i] - 'a'];
		}
		//单词结尾
		node.word = word;
	}
}
public class Solution {
	public List<String> findWords(char[][] board, String[] words){
		Trie trie = new Trie();
		List<String> res = new ArrayList<String>();
		//将所有单词存于前缀树中
		for (String word : words) {
			trie.insert(word);
		}
		
		int rows = board.length;
		int cols = board[0].length;
		if(rows == 0) {
			return res;//空的list
		}
		//从网格的每个位置开始遍历
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				backTrack(board, i, j, trie.root, res);
			}
		}
		return res;
		
	}
	public void backTrack(char[][] board, int row, int col, TrieNode parent, List<String> res) {
		
		//参数检验
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
			return ;
		}
		
		char c = board[row][col];//将要遍历的字母
		//该字母被访问过或者该字母在前缀树中不存在
		if(c == '$' || parent.children[c - 'a'] == null) {
			return ;
		}
		
		TrieNode node = parent.children[c - 'a'];
		//若当前节点是一个单词的结尾
		if(node.word != null) {
			//加入到结果中
			res.add(node.word);
			//将标记置空，避免重复加入
			node.word = null;
		}
		char tmp = board[row][col];
		//上下左右遍历
		board[row][col] = '$';
		backTrack(board, row-1, col, node, res);
		backTrack(board, row, col+1, node, res);
		backTrack(board, row+1, col, node, res);
		backTrack(board, row, col-1, node, res);
		board[row][col] = tmp;//回溯
		
		
	}
	public static void main(String[] args) {
		Solution obj = new Solution();
		String[] words = {"oath","pea","eat","rain"};
		char[][] board = {{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}};
		List<String> res = obj.findWords(board, words);
		System.out.println(res);

	}

}
