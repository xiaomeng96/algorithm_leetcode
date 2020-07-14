package _046;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * @author xiaomeng
 *
 */
public class Solution {
	/**
	 * 回溯算法（深度优先遍历+状态重置）
	 * 时间复杂度：O(n*n!)，backtrack被调用的次数为O(n!), 叶节点有n!个，将答案复制到数组中需要O(n)时间
	 * 空间复杂度：O(n)，递归栈的空间，即递归的深度
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> permute(int[] nums) {
    	
    	List<List<Integer>> res=new ArrayList<>();
    	int len = nums.length;
    	if(len == 0)
    		return res;
    	int[] visited =new int[len];
    	backtrack(nums, res, new ArrayList<>(), visited);
    	return res;
    	
    }
    
    public void backtrack(int[] nums, List<List<Integer>> res, ArrayList<Integer> path, int[] visited) {
    	//递归出口
    	if(path.size() == nums.length) {
    		res.add(new ArrayList<>(path));
    		return;
    	}
    	for (int i = 0; i < nums.length; i++) {
    		if(visited[i] == 1)
    			continue;
    		path.add(nums[i]);
    		visited[i] = 1;
    		backtrack(nums, res, path, visited);//固定一个数，继续去找下一个
    		//重置
    		visited[i] = 0;
    		path.remove(path.size()-1);			
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums= {1,2,3};
		List<List<Integer>> res=so.permute(nums);
		System.out.println(res);

	}

}
