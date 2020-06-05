package _001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	//哈希表
	/**
	 * 1. 两数之和
	 * 时间复杂度O(n),空间O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int tmp = target-nums[i];
			if(map.containsKey(tmp)) {
				return new int[] {map.get(tmp), i};
			}else {
				map.put(nums[i], i);
			}
		}
		//没有找到两个和为target的数，抛出异常
		throw new IllegalArgumentException("No two sum solution");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums=new int[] {3, 2, 4};
		int[] res=so.twoSum2(nums, 6);
		System.out.println(res[0] + " "+res[1]);
	}

}
