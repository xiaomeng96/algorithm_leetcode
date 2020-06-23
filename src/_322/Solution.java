package _322;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * @author xm
 *
 */
public class Solution {
	/**
	 * 动态规划
	 * 1.确定状态：原问题和子问题中变化的量；本例为amount
	 * 2.确定dp数组的定义：是用来保存什么的；本例为从1到amount金额所需的最少的硬币数
	 * 3.确定选择并择优：对于每个状态，可以做出什么选择改变当前状态
	 * 4.明确base case：本例中，当目标金额为0时，所需硬币数量为0；当目标金额小于0时，无解返回-1
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		if(coins.length == 0) {
			return -1;
		}
		int max = amount + 1;
		int[] dp = new int[amount+1];//保存从1到amount每个金额所需的最少硬币数
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i < amount+1; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0) {//金额i包含coins[j]
					dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
				}
			}
		}
		
		return dp[amount] > amount? -1:dp[amount];
		
	}
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.coinChange(new int[] {1, 2, 5}, 11));
		System.out.println(so.coinChange(new int[] {2}, 11));
		System.out.println(so.coinChange(new int[] {1, 7, 10}, 14));

	}

}
