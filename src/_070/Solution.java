package _070;

/**
 * 70. 爬楼梯
 * @author xiaomeng
 *
 */
public class Solution {

	/**
	 * 方法1：动态规划
	 * 时间复杂度：O(n)，空间复杂度：O(n)
	 * 到达第n阶，可以从第n-1阶爬1个台阶到达，也可以从第n-2阶爬2个台阶到达
	 * @param n
	 * @return
	 */
    public int climbStairs(int n) {
    	if(n<=3)
    		return n;
    	int[] dp = new int[n+1];
    	dp[1]=1;
    	dp[2]=2;
    	for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
    	return dp[n];
    }
    
    /**
     * 方法2：斐波那契数列
     * 空间为O(1)
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
    	if(n<=3)
    		return n;
    	int first=1;
    	int second=2;
    	int res=0;
    	for (int i = 3; i < n+1; i++) {
			res=first+second;
			first=second;
			second=res;
		}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution so=new Solution();
		System.out.println(so.climbStairs(3));
		System.out.println(so.climbStairs2(3));
	}

}
