package _718;
/**
 * 718. 最长重复子数组
 * @author xm
 *
 */
public class SolutionDP {
	/**
	 * 动态规划
	 * dp[i][j]:A中长度为i-1的字串和B中长度为j-1的字串，最长公共子串的长度
	 * 状态转移方程：当A[i-1] == B[j-1],dp[i][j] = dp[i-1][j-1]-1; A[i-1] != B[j-1], dp[i][j] = 0;
	 * basecase：dp[0][0] = dp[i][0] = dp[0][j] = 0
	 * 返回值：max
	 * 时间复杂度：O(n2)
	 * 空间复杂度：O(n2)
	 * @param A
	 * @param B
	 * @return
	 */
    public int findLength(int[] A, int[] B) {
    	//定义dp数组
    	int[][] dp = new int[A.length+1][B.length+1];
    	int max = 0;
    	for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				 if(A[i-1] == B[j-1]) {
					 dp[i][j] = dp[i-1][j-1] + 1;
					 
				 }else {
					 dp[i][j] = 0;
				 }
				 max = Math.max(max, dp[i][j]);
			}
		}
    	return max;
    	

    }
	public static void main(String[] args) {
		SolutionDP obj = new SolutionDP();
		int[] A = new int[] {1,2,3,2,1};
		int[] B = new int[] {3,2,1,4,7};
		System.out.println(obj.findLength(A, B));
	}

}
