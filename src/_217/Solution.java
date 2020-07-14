package _217;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * @author xm
 *
 */
public class Solution {
	/**
	 * 本题是环状排列，相当于偷窃了第一家就不能偷窃最后一家，可以把环状排列的问题简化为两个单排列问题
	 * 1.在不偷窃第一家的情况下，即nums[1:]，最大金额为p1
	 * 2.在不偷窃最后一家的情况下，即nums[:nums.length-1]，最大金额为p2
	 * 综合偷窃的最大金额为max(p1, p2);
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {

    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	if(nums.length == 1) {
    		return nums[0];
    	}
    	return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length-1)), myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    	
    }
    private int myRob(int[] nums) {
    	int first = 0, second = 0, tmp;
    	for (int num : nums) {
			tmp = second;
			second = Math.max(first+num, second);
			first = tmp;
		} 
    	return second;
    }
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.rob(new int[] {2, 23, 9, 3, 20}));
		System.out.println(so.rob(new int[] {1, 2, 3, 1}));
		System.out.println(so.rob(new int[] {2,7,9,3,1}));
		System.out.println(so.rob(new int[] {2,7}));
	}

}
