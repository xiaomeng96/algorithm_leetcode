package _200;
/**
 * 200. 岛屿数量
 * @author xm
 *
 */
public class SolutionDFS {
	/**
	 * DFS
	 * @param grid
	 * @return
	 */
    public int numIslands(char[][] grid) {
    	int m = grid.length;
    	if(m == 0) {
    		return 0;
    	}
    	int n = grid[0].length;
    	int numIslands = 0;
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j] == '1') {//每递归一次，代表找到一个新的岛屿
					numIslands++;
					dfs(i, j, grid);
				}
			}
		}
    	return numIslands;

    }
    public void dfs(int i, int j, char[][] grid) {
    	if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
    		return;
    	}
    	
    	grid[i][j] = '0';
    	dfs(i-1, j, grid);
    	dfs(i, j+1, grid);
    	dfs(i+1, j, grid);
    	dfs(i, j-1, grid);
    }
	public static void main(String[] args) {
		SolutionDFS obj = new SolutionDFS();
		char[][] grid = {{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '1', '0'}};
		System.out.println(obj.numIslands(grid));

	}

}
