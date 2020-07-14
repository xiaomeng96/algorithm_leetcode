package _130;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {
	/**
	 * 非递归的BFS
	 * 寻找和边界相连的'O'区域
	 * @param board
	 */
    public void solve(char[][] board) {

    	if(board == null || board.length == 0) {
    		return;
    	}
    	int m = board.length;
    	int n = board[0].length;
    	Queue<Integer> queue = new LinkedList<>();
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean isEdge = i == 0 || i == m-1 || j == 0 || j == n-1;
				if(isEdge && board[i][j] == 'O') {
					queue.add(i*n+j);
					board[i][j] = '#';
					while(!queue.isEmpty()) {
						int num = queue.poll();
						int row = num/n;
						int col = num%n;
						if(row-1>=0 && board[row-1][col] == 'O') {
							queue.add((row-1)*n+col);
							board[row-1][col] = '#';
						}
						if(row+1 < m && board[row+1][col] == 'O') {
							queue.add((row+1)*n+col);
							board[row+1][col] = '#';
						}
						if(col-1 >= 0 && board[row][col-1] == 'O') {
							queue.add(row*n+col-1);
							board[row][col-1] = '#';
						}
						if(col+1 < n && board[row][col+1] == 'O') {
							queue.add(row*n+col+1);
							board[row][col+1] = '#';
						}
					}
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
	public static void main(String[] args) {
		SolutionBFS obj = new SolutionBFS();
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
