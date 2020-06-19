package _1143;

/**
 * 1143. 最长公共子序列
 * @author xm
 *
 */
public class Solution {
	/**
	 * 动态规划（DP）
	 * 思路
	 * 1.明确dp数组的含义
	 * 2.第一base case
	 * 3.找状态转移方程
	 * @param text1
	 * @param text2
	 * @return
	 */
    public int longestCommonSubsequence(String text1, String text2) {
    	if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
    		return 0;
    	}
    	
    	int n1 = text1.length();
    	int n2 = text2.length();
    	int[][] dp = new int[n1+1][n2+1];//初始化值都为0
    	
    	for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
    	return dp[n1][n2];

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		System.out.println(so.longestCommonSubsequence("abcde", "ace"));
		System.out.println(so.longestCommonSubsequence("abc", "abc"));
		System.out.println(so.longestCommonSubsequence("abc", "def"));

	}

}
