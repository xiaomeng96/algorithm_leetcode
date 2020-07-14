package _529;

/**
 * 529. 扫雷游戏
 * @author xm
 *
 */
public class Solution {
	/**
	 * 方法1：DFS
	 * 对于给定位置，如果是'E'，先置为'B'，
	 * 再判断其周围是否有雷，若有雷，将其位置上修改为雷的数量，如果没有，就继续dfs搜索相邻位置
	 * @param board
	 * @param click
	 * @return
	 */
	int[] dx= {-1, -1, 0, 1, 1, 1, 0, -1};//设置相邻位置位移
	int[] dy= {0, 1, 1, 1, 0, -1, -1, -1};
	
    public char[][] updateBoard(char[][] board, int[] click) {
    	
    	dfs(board, click[0], click[1]);
    	return board;
    }

    public void dfs(char[][] board, int x, int y) {
    	int r=board.length;
    	int c=board[0].length;
    	//边界条件控制
    	if(x < 0 || x >= r || y < 0 || y >= c)
    		return;
    	
    	if(board[x][y] == 'E') {
    		board[x][y] = 'B';
    		int count = countThunder(board, x, y);
    		if(count == 0) {//周围没有雷，继续递归
    			for(int i=0; i < 8; i++) {
    				dfs(board, x+dx[i], y+dy[i]);
    			}
    		}else {
    			board[x][y] = (char)(count+'0');
    		}
    	}else if(board[x][y] == 'M') {
    		board[x][y] = 'X';
    	}
    }
    
    public int countThunder(char[][] board, int x, int y) {
    	int r=board.length;
    	int c=board[0].length;
    	
    	int count=0;
    	for (int i = 0; i < 8; i++) {
			int newX=x+dx[i];
			int newY=y+dy[i];
			
			if(newX < 0 || newX >= r || newY < 0 || newY >= c)
				continue;
			
			if(board[newX][newY] == 'M')//计算周围雷的个数
				count++;
		}
    	
    	return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		char[][] board= {{'E', 'E', 'E', 'E', 'E'},
				{'E', 'E', 'M', 'E', 'E'},
				{'E', 'E', 'E', 'E', 'E'},
				{'E', 'E', 'E', 'E', 'E'}};
		int[] click= {3, 0};
		char[][] res=so.updateBoard(board, click);
		char[][] res2=so.updateBoard(res, new int[] {1, 2});
		
		for (char[] cs : res2) {
			System.out.println(cs);
		}

	}

}
