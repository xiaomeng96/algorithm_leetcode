package _051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 51. N皇后
 * @author xm
 *
 */
public class SolutionDFS {
	/**
	 * 回溯法 
	 * 从第0行开始遍历 每一行判断列、主副对角线皇后是否发生冲突 
	 *     没有冲突，记录该位置，并继续找下一个皇后的位置 
	 *     再回溯
	 * 当走到第n行的时候，说明n个皇后位置都找到，即找到其中一个解 
	 * 时间复杂度：O(n!) 
	 * 空间复杂度：O(n)
	 * 
	 * @param n
	 * @return
	 */
	private boolean[] col;
	private boolean[] master;// 记录主对角线
	private boolean[] slave;// 记录副对角线
	private List<List<String>> res = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		col = new boolean[n];
		master = new boolean[2 * n - 1];// 主副对角线分别有2n-1条
		slave = new boolean[2 * n - 1];
		List<Integer> list = new ArrayList<Integer>();// 记录皇后的位置

		dfs(n, 0, list);

		return res;

	}

	public void dfs(int n, int row, List<Integer> list) {
		if (row == n) {// 找到其中一组解
			res.add(changeToBoard(list, n));
			return;
		}
		// 固定行row，对每个皇后遍历每列
		for (int i = 0; i < n; i++) {
			// slave[row+i]:副对角线横纵坐标相加
			// master[row-i + n-1]：主对角线横纵坐标相加，加上n-1是为了，让主对角线坐标从0开始
			if (!col[i] && !master[row - i + n - 1] && !slave[row + i]) {// 该位置皇后没有冲突
				// 记录该位置，并将标记该位置冲突的地方
				col[i] = true;
				master[row - i + n - 1] = true;
				slave[row + i] = true;
				list.add(i);

				dfs(n, row + 1, list);

				// 回溯
				col[i] = false;
				master[row - i + n - 1] = false;
				slave[row + i] = false;
				list.remove(list.size() - 1);
			}
		}

	}

	public List<String> changeToBoard(List<Integer> list, int n) {
		List<String> tmp = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			char[] c = new char[n];
			Arrays.fill(c, '.');// 将c中所有元素都初始化为'.'
			c[list.get(i)] = 'Q';
			tmp.add(new String(c));
		}
		return tmp;
	}

	public static void main(String[] args) {
		SolutionDFS obj = new SolutionDFS();
		List<List<String>> res = obj.solveNQueens(4);
		for (List<String> list : res) {
			for (String str : list) {
				System.out.println(str);
			}
			System.out.println();
		}

	}

}
