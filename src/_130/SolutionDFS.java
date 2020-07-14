package _130;
/**
 * 130. 被围绕的区域
 * @author xm
 *
 */
public class SolutionDFS {
	/**
	 * DFS
	 * 通过DFS找和边界'O'连通的'O'区域，先标记为'#'	
	 * 时间复杂度O(n2)
	 * 空间复杂度O(n2)
	 * @param board
	 */
    public void solve(char[][] board) {
    	int m = board.length;
    	if(m == 0) {
    		return;
    	}
    	int n = board[0].length;
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean isEdge = i == 0 || i == m-1 || j == 0 || j == n-1;
				if(isEdge && board[i][j] == 'O') {
					dfs(board, i, j);
				}
			}
		}
    	
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}else if(board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}

    }
    public void dfs(char[][] board, int i, int j) {
    	//越过边界、已经访问过的、遇到'X'的直接返回
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || board[i][j] == 'X') {
    		return;
    	}
    	board[i][j] = '#';
    	dfs(board, i-1, j);
    	dfs(board, i, j+1);
    	dfs(board, i+1, j);    	
    	dfs(board, i, j-1);
    }
	public static void main(String[] args) {
		SolutionDFS obj = new SolutionDFS();
		char[][] board = {{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}};
		obj.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

}
