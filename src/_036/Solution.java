package _036;

/**
 * 36. 有效的数独
 * 
 * @author xm
 *
 */
public class Solution {
	/*
	 * 每行只能出现一次 每列只能出现一次 每个3*3的块只能出现一次
	 */
	public boolean isValidSudoku(char[][] board) {
		// 参数检验
		if (board.length != 9) {
			return false;
		}
		// 记录每行，某位数字是否已经被摆放过
		boolean[][] row = new boolean[9][9];
		// 记录每列，某位数字是否已经被摆放过
		boolean[][] col = new boolean[9][9];
		// 记录每个3*3的块，某位数字是否被摆放过
		boolean[][] block = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '1';// 将1~9转换为0~8
					int blockIndex = (i / 3) * 3 + j / 3;// 定位board[i][j]在哪个3*3块
					if (row[i][num] || col[j][num] || block[blockIndex][num]) {
						return false;
					} else {
						row[i][num] = true;
						col[j][num] = true;
						block[blockIndex][num] = true;
					}
				}

			}
		}
		return true;

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		char[][] board = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(obj.isValidSudoku(board));

	}

}
