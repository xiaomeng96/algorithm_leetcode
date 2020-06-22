package _064;

public class Solution0 {
	/**
	 * 动态规划（不需要额外的空间）
	 * 时间复杂度O(mn)
	 * 空间复杂度O(1)
	 * @param grid
	 * @return
	 */
    public int minPathSum(int[][] grid) {
    	int row = grid.length-1;
    	int col = grid[0].length-1;
    	//参数校验
    	if(row+1 == 0 || col+1 == 0) {
    		return 0;
    	}
    	
    	for(int i = row; i>=0; i--) {
    		for(int j = col; j>=0; j--) {
    			if(i == row && j != col) {//最后一行的数据
    				grid[i][j] = grid[i][j] + grid[i][j+1];
    			}else if(i != row && j == col) {//最后一列的数据
    				grid[i][j] = grid[i][j] + grid[i+1][j];
    			}else if(i != row && j != col) {//既不在最后一行，也不在最后一列的数据
    				grid[i][j] = grid[i][j] + Math.min(grid[i+1][j], grid[i][j+1]);
    			}
    		}
    	}
//    	for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				System.out.print(grid[i][j]);
//			}
//			System.out.println();
//		}
    	return grid[0][0];

    }
	public static void main(String[] args) {
		Solution0 so = new Solution0();
		int[][] grid = {{1,3,1},
				{1,5,1},
				{4,2,1}};
		System.out.println(so.minPathSum(grid));

	}

}
