package _053;

/**
 * 53. 最大子序和
 * @author xm
 *
 */
public class Solution {
	/**
	 * 方法1：动态规划
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
    	int ans=nums[0];
    	int sum=0;
    	
    	for (int i = 0; i < nums.length; i++) {
			if(sum+nums[i] > nums[i]) {
				sum += nums[i];
			}else {
				sum=nums[i];
			}
			ans = Math.max(ans, sum);
		}
    	return ans;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums2= {-2, -3, -4, -5, -1};
		int[] nums3= {};
		System.out.println(so.maxSubArray(nums));
		System.out.println(so.maxSubArray(nums2));
		System.out.println(so.maxSubArray(nums3));

	}

}
