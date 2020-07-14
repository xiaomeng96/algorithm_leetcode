package _169;

import java.util.Arrays;

public class Solution2 {
	/**
	 * 方法2：排序法（还有一种分治法，时间和空间复杂度差不多）
	 * nums排序之后，下标为n/2的元素一定是众数
	 * 
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(logn)
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums= {3, 2, 3};
		System.out.println(so.majorityElement(nums));
		int[] nums2= {2,2,1,1,1,2,2};
		System.out.println(so.majorityElement(nums2));
	}

}
