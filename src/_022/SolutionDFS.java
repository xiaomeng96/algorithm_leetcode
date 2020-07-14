package _022;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 
 * @author xm
 *
 */
public class SolutionDFS {
	/*
	 * 深度优先遍历DFS+减枝 画图 时间复杂度：O() 空间复杂度：O(n)
	 */
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
		dfs("", n, n, res);
		return res;
	}

	/**
	 * @param curStr 当前括号匹配字符串
	 * @param left   左边剩余的括号数
	 * @param right  右边剩余的括号数
	 * @param res
	 */
	public void dfs(String curStr, int left, int right, List<String> res) {

		// 递归出口，左边括号数和右边括号数都为0
		// 就将当前的括号匹配的字符串添加到结果列表中
		if (left == 0 && right == 0) {
			res.add(curStr);
			return;
		}
		// 左边剩余的括号数大于右边剩余的括号数，就减枝
		if (left > right) {
			return;
		}
		if (left > 0) {
			dfs(curStr + "(", left - 1, right, res);
		}
		if (right > 0) {
			dfs(curStr + ")", left, right - 1, res);
		}
	}

	public static void main(String[] args) {
		SolutionDFS obj = new SolutionDFS();
		System.out.println(obj.generateParenthesis(3));

	}

}
