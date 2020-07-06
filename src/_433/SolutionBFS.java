package _433;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 433. 最小基因变化
 * 
 * @author xm
 *
 */
public class SolutionBFS {
	/**
	 * BFS 解决状态搜索
	 * 
	 * @param start
	 * @param end
	 * @param bank
	 * @return
	 */
	public int minMutation(String start, String end, String[] bank) {
		// 将bank数组转化为HashSet
		HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
		// 参数检验
		if (!bankSet.contains(end)) {
			return -1;
		}
		// 四个状态
		char[] c = { 'A', 'C', 'G', 'T' };
		// 广度优先队列
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		bankSet.remove(start);
		int seqLen = start.length();
		int step = 0;// 步数

		while (!queue.isEmpty()) {
//			step++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				// 从队列中取出一个基因序列字符串，转化为字符数组
				char[] seqArray = queue.poll().toCharArray();
				for (int j = 0; j < seqLen; j++) {// 遍历这个字符数组的每一个字符
					char oldChar = seqArray[j];
					for (int k = 0; k < 4; k++) {// 用四个状态分别替换该字符
						seqArray[j] = c[k];
						String newSeq = new String(seqArray);// 得到新的基因序列
						if (newSeq.equals(end)) {// 新的基因序列和目标序列匹配
							return step + 1;
						} else if (bankSet.contains(newSeq)) {// 基因库中包含一次基因变化后的基因序列
							bankSet.remove(newSeq);
							queue.add(newSeq);
						}
					}
					seqArray[j] = oldChar;// 变回原来的状态，便于改变下一个字符的状态
				}
			}
			step++;
		}
		return -1;

	}

	public static void main(String[] args) {
		SolutionBFS obj = new SolutionBFS();
		System.out.println(obj.minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" }));
		System.out
				.println(obj.minMutation("AACCGGTT", "AAACGGTA", new String[] { "AACCGGTA", "AACCGCTA", "AAACGGTA" }));
		System.out
				.println(obj.minMutation("AAAAACCC", "AACCCCCC", new String[] { "AAAACCCC", "AAACCCCC", "AACCCCCC" }));
	}

}
