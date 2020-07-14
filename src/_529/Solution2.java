package _529;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

	/**
	 * 方法2：BFS
	 * @param board
	 * @param click
	 * @return
	 */
	int[] dx= {-1, -1, 0, 1, 1, 1, 0, -1};//设置相邻位置位移
	int[] dy= {0, 1, 1, 1, 0, -1, -1, -1};
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public char[][] updateBoard(char[][] board, int[] click){
		int r=board.length;
		int c=board[0].length;
		Queue<Node> queue=new LinkedList<>();//广度优先遍历队列
		queue.add(new Node(click[0], click[1]));
		
		while(!queue.isEmpty()) {
			Node tmp=queue.poll();
			int x=tmp.x;
			int y=tmp.y;
			if(board[x][y] == 'E') {
				board[x][y] = 'B';
				int count=countThunder(board, x, y);
				if(count == 0) {
					for (int i = 0; i < 8; i++) {
						int newX=x+dx[i];
						int newY=y+dy[i];
						if(newX < 0 || newX >= r || newY < 0 || newY >= c)
							continue;
						queue.add(new Node(newX, newY));
					}
				}else {
					board[x][y] = (char)(count+'0');
				}
			}else if(board[x][y] == 'M') {
				board[x][y] = 'X';
			}
		}
		
		return board;
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
//		char[][] res2=so.updateBoard(res, new int[] {1, 2});
		
		for (char[] cs : res) {
			System.out.println(cs);
		}
	}

}
