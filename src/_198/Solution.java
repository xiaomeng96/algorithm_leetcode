package _198;

/**
 * 198.打家劫舍
 * @author xm
 *
 */
public class Solution {
	/**
	 * 动态规划
	 * base case：
	 *     当只有1家的时候，偷窃的最高金额为nums[0];
	 *     当有2家的时候，偷窃的最高金额为max(nums[0],nums[1])
	 * 状态转移方程
	 * 	     偷第k-1家就不偷第k家，dp[i] = max(dp[i-2]+nums[i], dp[i-1]);
	 * 
	 * 时间复杂度：O(n)
	 * 空间复杂度: O(n)
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {

    	//参数校验
    	if(nums.length == 0 || nums == null) {
    		return 0;
    	}
    	if(nums.length == 1) {
    		return nums[0];
    	}
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	dp[1] = Math.max(nums[0], nums[1]);
    	for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		}
    	return dp[nums.length-1];
    	
    	
    }
    /*
     * dp改进
     * dp中每间房屋最高存储金额只和前两间房屋有关，因此，每个时刻只需要存储两间房屋的最高金额
     */
    public int rob2(int[] nums) {
    	//参数检验
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	if(nums.length == 1) {
    		return nums[0];
    	}
    	int first = nums[0];
    	int second = Math.max(nums[0], nums[1]);
    	for (int i = 2; i < nums.length; i++) {
			int temp = second;
			second = Math.max(first+nums[i], second);
			first = temp;
		}
    	return second;
    }
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.rob(new int[] {1, 2, 3, 1}));
		System.out.println(so.rob(new int[] {2,7,9,3,1}));
		System.out.println(so.rob2(new int[] {1, 2, 3, 1}));
		System.out.println(so.rob2(new int[] {2,7,9,3,1}));
	}

}
