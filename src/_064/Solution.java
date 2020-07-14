package _064;

/**
 * 64. 最小路径和
 * @author xm
 *
 */
public class Solution {
	/**
	 * 二维动态规划
	 * 时间复杂度O(mn)
	 * 空间复杂度O(mn)
	 * @param grid
	 * @return
	 */
    public int minPathSum(int[][] grid) {
    	int row = grid.length-1;
    	int col = grid[0].length-1;
    	int[][] dp = new int[row+1][col+1];
    	//参数校验
    	if(row+1 == 0 || col+1 == 0) {
    		return 0;
    	}
    	
    	for(int i = row; i>=0; i--) {
    		for(int j = col; j>=0; j--) {
    			if(i == row && j != col) {//最后一行的数据
    				dp[i][j] = grid[i][j] + dp[i][j+1];
    			}else if(i != row && j == col) {//最后一列的数据
    				dp[i][j] = grid[i][j] + dp[i+1][j];
    			}else if(i != row && j != col) {//既不在最后一行，也不在最后一列的数据
    				dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
    			}else {//右下角的数据
    				dp[i][j] = grid[i][j];
    			}
    		}
    	}
//    	for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
    	return dp[0][0];

    }
	public static void main(String[] args) {
		Solution so = new Solution();
		int[][] grid = {{1,3,1},
				{1,5,1},
				{4,2,1}};
		System.out.println(so.minPathSum(grid));

	}

}
