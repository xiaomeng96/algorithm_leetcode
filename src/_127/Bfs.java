package _127;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bfs {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// 参数检验
		if (wordList.size() == 0 || !wordList.contains(endWord)) {
			return 0;
		}
		// 将单词集合放到哈希表中，优化访问时间
		Set<String> wordSet = new HashSet<>(wordList);
		wordSet.remove(beginWord);

//		// BFS访问队列
//		Queue<String> queue = new LinkedList<>();
//		queue.add(beginWord);

		// 分别用左扩散和右扩散的哈希表代表BFS的优先队列
		Set<String> begin = new HashSet<>();
		begin.add(beginWord);
		Set<String> end = new HashSet<>();
		end.add(endWord);

		// 总的访问标志数组
		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);

		int wordLen = beginWord.length();// 单词长度
		// 步数，起始单词为第一步
		int step = 1;
		while (!begin.isEmpty() && !end.isEmpty()) {

			// 让begin总是指向小的集合，这样考虑的情况更少
			if (begin.size() > end.size()) {
				Set<String> tmp = begin;
				begin = end;
				end = tmp;
			}

			Set<String> neighbor = new HashSet<String>();
			for (String word : begin) {
				char[] charArray = word.toCharArray();
				// 遍历当前单词每一个字符
				for (int i = 0; i < wordLen; i++) {
					char oldChar = charArray[i];// 保留原来的字符
					// 用26个字符分别替换当前字符
					for (char c = 'a'; c <= 'z'; c++) {
						if (charArray.equals(c)) {// 和原来的字符一样，继续执行
							continue;
						}
						// 否则就替换掉
						charArray[i] = c;
						// 得到与原单词只相差一个字符的新单词
						String nextWord = String.valueOf(charArray);
						// 判断单词集合是否包含这个新的单词
						if (wordSet.contains(nextWord)) {
							// 在中间相遇了，即找到从开始单词到结尾单词的最短路径
							if (end.contains(nextWord)) {
								return step + 1;
							}
							// 没有到达尾部，看看是否被访问过
							if (!visited.contains(nextWord)) {
								neighbor.add(nextWord);// 没有被访问过就添加到队列，作为下一层节点
								visited.add(nextWord);
							}

						}
					}
					// 当前字符都替换完毕后，需要恢复其原来的值，准备下一个字符的替换
					charArray[i] = oldChar;
				}
			}
			begin = neighbor;
			// 一层单词节点遍历完毕，步数+1
			step++;
		}

		// 走到这一步，说明没有找到路径
		return 0;

	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		String[] wordListArray = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
		Collections.addAll(wordList, wordListArray);
		Bfs obj = new Bfs();
		System.out.println(obj.ladderLength(beginWord, endWord, wordList));

	}

}
