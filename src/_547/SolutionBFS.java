package _547;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {
	/**
	 * 方法2：BFS
	 * 时间复杂度：O(n2)
	 * 空间复杂度：O(n)
	 * @param M
	 * @return
	 */
	public int findCircleNum(int[][] M) {
		//参数检验
		if(M.length == 0) {
			return 0;
		}
		int[] visited = new int[M.length];
		Queue<Integer> queue = new LinkedList<>();//BFS队列
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			if(visited[i] == 0) {//每进入一次就是一个新的朋友圈
				queue.add(i);
				while(!queue.isEmpty()) {
					int s = queue.remove();
					visited[s] = 1;
					for (int j = 0; j < visited.length; j++) {
						if(M[s][j] == 1 && visited[j] == 0) {
							queue.add(j);
						}
					}
				}
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		SolutionBFS obj = new SolutionBFS();
		int[][] M = new int[][] {{1,1,0},
			{1,1,0},
			{0,0,1}};
		System.out.println(obj.findCircleNum(M));

	}

}
