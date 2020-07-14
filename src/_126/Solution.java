package _126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 126. 单词接龙 II
 * @author xm
 *
 */
public class Solution {
	/**
	 * BFS
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    	List<List<String>> ans=new ArrayList<>();
    	
    	if(!wordList.contains(endWord)) {
    		return ans;
    	}
    	bfs(beginWord, endWord, wordList, ans);
    	return ans;
    }
    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
    	Queue<List<String>> queue = new LinkedList<>();//BFS队列
    	List<String> path=new ArrayList<>();
    	path.add(beginWord);
    	queue.add(path);
    	
    	boolean isFound=false;
    	Set<String> dict=new HashSet<>(wordList);//为了提高速度，将List转为HashSet
    	Set<String> visited = new HashSet<>();//标记集合
    	visited.add(beginWord);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		Set<String> subVisited=new HashSet<String>();
    		for (int i = 0; i < size; i++) {//遍历queue中当前层保存的路径
				List<String> p=queue.poll();//队列先进先出
				String word=p.get(p.size()-1);//得到当前路径中的末尾单词
				ArrayList<String> neighbors = getNeighbors(word, dict);
				for(String neighbor: neighbors) {
					if(neighbor.equals(endWord)) {
						isFound=true;
						p.add(neighbor);
						ans.add(new ArrayList<String>(p));
						p.remove(p.size()-1);
//						System.out.println(visited);
					}
					//只考虑之前没有出现过的单词
					if(!visited.contains(neighbor)) {
						//加入当前单词
						p.add(neighbor);
						queue.offer(new ArrayList<String>(p));
						p.remove(p.size()-1);
						subVisited.add(neighbor);
					}
				}
				
			}
    		visited.addAll(subVisited);
//    		System.out.println(visited);
    		if(isFound) {
    			break;
    		}
    	}
    	
	
    }
    
    //得到某个单词的所有邻居
    private ArrayList<String> getNeighbors(String node, Set<String> dict){
    	ArrayList<String> res=new ArrayList<String>();
    	char[] chs=node.toCharArray();
    	for (char c = 'a'; c <= 'z'; c++) {
			for(int i=0; i < chs.length; i++) {
				if(chs[i] == c) {
					continue;
				}
				char oldchar=chs[i];
				chs[i] = c;
				if(dict.contains(String.valueOf(chs))) {
					res.add(String.valueOf(chs));
				}
				chs[i]=oldchar;
			}
		}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution so=new Solution();
		List<String> wordList=Arrays.asList("hot","dot","dog","lot","log","cog");
		List<List<String>> ans=so.findLadders("hit", "cog", wordList);	
		
//		List<String> wordList=Arrays.asList("rex", "ted", "tex", "tad", "tax");
//		List<List<String>> ans=so.findLadders("red", "tax", wordList);	
		for (List<String> list : ans) {
			System.out.println(list);
		}
	}

}
