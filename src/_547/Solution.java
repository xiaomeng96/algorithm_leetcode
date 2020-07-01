package _547;
/**
 * 547. 朋友圈
 * @author xm
 *
 */
public class Solution {
	/**
	 * 方法1：DFS
	 * 时间复杂度O(n2)
	 * 空间复杂度O(n)
	 * @param M
	 * @return
	 */
    public int findCircleNum(int[][] M) {
    	//参数检验
    	if(M.length == 0) {
    		return 0;
    	}
    	int[] visited = new int[M.length];//访问标志数组
    	int count = 0;
    	for (int i = 0; i < M.length; i++) {
			if(visited[i] == 0) {//每递归一次，就代表找到一个新的朋友圈
				dfs(M, visited, i);
				count++;
			}
		}
    	return count;
    	
    }
    public void dfs(int[][] M, int[] visited, int i) {
    	for(int j = 0; j < M.length ; j++) {
    		//若i和j是朋友，且j没有被访问过
    		if(M[i][j] == 1 && visited[j] == 0) {
    			visited[j] = 1;//访问j
    			dfs(M, visited, j);
    		}
    	}
    }
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[][] M = new int[][] {{1,1,0},
			{1,1,0},
			{0,0,1}};
		System.out.println(obj.findCircleNum(M));	
			

	}

}
