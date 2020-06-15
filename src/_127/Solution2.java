package _127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution2 {
	/**
	 * 方法2：双向广度优先搜索
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord))
			return 0;
		
		int n=beginWord.length();//每个单词长度一样
		//key是通用单词，value是通用单词匹配的单词列表
		Map<String, List<String>> allCombWord= new HashMap<>();
		wordList.forEach(
				word->{
					for (int i = 0; i < n; i++) {
						String newWord=word.substring(0, i) + "*" + word.substring(i+1, n);
						List<String> trans=allCombWord.getOrDefault(newWord, new ArrayList<>());
						trans.add(word);
						allCombWord.put(newWord, trans);
					}
				});
		
		//实现双向BFS
		//使用HashSet实现BFS
		HashSet<String> begin=new HashSet<>();
		HashSet<String> end=new HashSet<>();
		begin.add(beginWord);
		end.add(endWord);
		
		//访问数组
		HashSet<String> visited=new HashSet<>();
		int level=1;
		while(!begin.isEmpty() && !end.isEmpty()) {
			//控制当前循环从哪个方向进行BFS；让begin总是指向size更小的集合，这样避免bfs总是朝着一个方向进行
			if(begin.size() > end.size()) {
				HashSet<String> tmp=begin;
				begin=end;
				end=tmp;
			}
			//记录遍历begin时每个元素的邻居
			HashSet<String> neighbor=new HashSet<>();
			for (String cur : begin) {
				for (int i = 0; i < n; i++) {
					String currCombWord = cur.substring(0, i) + "*" + cur.substring(i+1, n);
					//当cur是beginWord时，allCombWord没有统计它的通用状态，有可能会返回null
					if(!allCombWord.containsKey(currCombWord))
						continue;
					for (String word : allCombWord.get(currCombWord)) {
						if(end.contains(word))
							return level+1;
						if(!visited.contains(word)) {
							visited.add(word);
							neighbor.add(word);//记录邻居
						}
					}
				}
			}
			 //处理完begin中的元素后, 让begin指向begin中的元素的邻居
			begin=neighbor;
			level++;//路径长度+1
		}
		//没有找到
		return 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		String beginWord="hit";
		String endWord="cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.println(so.ladderLength(beginWord, endWord, wordList));
	}

}
