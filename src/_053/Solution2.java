package _053;

public class Solution2 {
	/**
	 * 分治算法
	 * 序列划分之后，计算左侧序列最大值，横跨中间子序列最大值，以及右侧最大值，然后选出三者中的最大值
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		return maxSum(nums, 0, nums.length-1);
	}
	public int maxSum(int[] nums, int start, int end) {
		if(start == end)
			return nums[start];
		
		int center = (start+end) / 2;
		int leftMax=maxSum(nums, start, center);
		int rightMax=maxSum(nums, center+1, end);
		
		//计算中间子序列最大值
		int leftCrossSum=0;
		int leftCrossMax=Integer.MIN_VALUE;
		for (int i = center; i >= start; i--) {
			leftCrossSum += nums[i];
			leftCrossMax = Math.max(leftCrossMax, leftCrossSum);
		}
		
		int rightCrossSum=0;
		int rightCrossMax=Integer.MIN_VALUE;
		for (int i = center+1; i <=end; i++) {
			rightCrossSum += nums[i];
			rightCrossMax = Math.max(rightCrossMax, rightCrossSum);
			
		}
		
		int crossMax=leftCrossMax+rightCrossMax;
		
		return Math.max(crossMax, Math.max(leftMax, rightMax));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums2= {-2, -3, -4, -5, -1};
//		int[] nums3= {};
		System.out.println(so.maxSubArray(nums));
		System.out.println(so.maxSubArray(nums2));
//		System.out.println(so.maxSubArray(nums3));
	}

}
