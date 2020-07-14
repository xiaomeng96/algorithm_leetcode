package _127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;





/**
 * 127. 单词接龙
 * @author xm
 *
 */
public class Solution {
	/**
	 * 方法1：广度优先搜索
	 * 思路：将问题抽象为一个无向无权图，每个单词作为节点，差距只有一个字母的两个单词之间连接一条边。
	 * 问题变为找到从起点到终点的最短路径。
	 * @param beginWord 起点单词
	 * @param endWord 终点单词
	 * @param wordList 给定的单词表
	 * @return
	 */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	
    	if(!wordList.contains(endWord))
    		return 0;
    	
    	int L=beginWord.length();//所有单词的长度都一样
    	Map<String, List<String>> allCombDict=new HashMap<>();//建立一个通用单词的邻接表
    	
    	for (String word : wordList) {
			for (int i = 0; i < L; i++) {
				String newWord=word.substring(0, i) + "*" + word.substring(i+1, L);
				//如果allCombDict包含newWord，就获取其对应的值，不包含的话就使用默认值
				List<String> transformation=allCombDict.getOrDefault(newWord, new ArrayList<>());
				transformation.add(word);
				allCombDict.put(newWord, transformation);
			}
		}
    	
    	
    	//BFS
    	Queue<Pair<String, Integer>> queue=new LinkedList<>();//广度优先遍历队列
    	//标记数组，判断某个节点是否已经被访问
    	//不采用List，因为ArrayList的contains方法比较低效
    	Map<String, Boolean> visited=new HashMap<>();
    	queue.add(new Pair<>(beginWord, 1));//开始词作为第一个节点，level是1
    	visited.put(beginWord, true);
    	//广度优先遍历，逐个取出队列中的元素进行操作
    	while(!queue.isEmpty()) {
    		Pair<String, Integer> node=queue.remove();
    		String currWord=node.getKey();
    		int level=node.getValue();
    		
    		for (int i = 0; i < L; i++) {
				//从当前单词获取L个通配词
    			String currCombWord=currWord.substring(0, i) + "*" + currWord.substring(i+1, L);
    			//拿到这个通配词对应的单词集合
    			List<String> currCombList = allCombDict.getOrDefault(currCombWord, new ArrayList<>());
    			for (String word : currCombList) {
    				//包含目标单词，说明当前单词能够一步到达目标单词
					if(word.equals(endWord))
						return level+1;
					//否则，如果这个单词还没有被访问过，就加入到队列中
					if(!visited.containsKey(word)) {
						queue.add(new Pair<>(word, level+1));
						//并标记已被访问
						visited.put(word, true);
					}
				}
			}
    		
    	}
    	
    	return 0;
        
    }
	public static void main(String[] args) {
		Solution so=new Solution();
		String beginWord="hit";
		String endWord="cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.println(so.ladderLength(beginWord, endWord, wordList));

	}

}
