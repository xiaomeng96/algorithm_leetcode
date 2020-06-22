package _077;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * @author xm
 *
 */
public class Solution {
	/**
	 * 和全排列类似，采用回溯+剪枝
	 * @param n
	 * @param k
	 * @return
	 */
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
    	//参数校验
    	if(n <= 0 || k <= 0 || n < k) {
    		return res;
    	}
    	backtrack(n, k, 1, new Stack<>());
    	return res;

    }
    /*
     * 剪枝
     * max(i) + 接下来要选择的元素个数 - 1 = n
     * 接下来要选择的元素个数 = k - stack.size();
     */
    public void backtrack(int n, int k, int begin, Stack<Integer> stack) {
    	
    	if(stack.size() == k) {
    		res.add(new ArrayList<Integer>(stack));
    		return;
    	}
    	
    	for (int i = begin; i <= n - (k - stack.size()) + 1; i++) {
			stack.add(i);
			backtrack(n, k, i+1, stack);
			stack.pop();//回溯
		}
    }
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.combine(4, 2));

	}

}
