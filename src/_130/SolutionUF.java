package _130;

/**
 * 方法3： 并查集：常用来解决连通性问题 同一个区域内的点都具有相同的的根节点
 * 
 * @author xm
 *
 */
class UnionFind {
	int[] parent;// 保存每个节点的父节点
	int[] size;// 保存每棵子树中节点个数

	public UnionFind(int n) {
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	/*
	 * 查找某个节点的根节点
	 */
	public int find(int x) {
		while (x != parent[x]) {// 如果x的根节点不是它本身
			parent[x] = parent[parent[x]];// 就沿着它的根节点往上找，直到找到最终的根节点
			x = parent[x];
		}
		return x;
	}

	/*
	 * 连接两个节点
	 */
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) {// p,q根节点相同，已经连通，直接返回
			return;
		}
		// 将节点少的连接到节点多的树上
		if (size[rootP] > size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}

	}

	/*
	 * 判断两个节点是否连通
	 */
	public boolean isConnection(int p, int q) {
		return find(p) == find(q);
	}
}

public class SolutionUF {

	public void solve(char[][] board) {
		// 参数检验
		if (board == null || board.length == 0) {
			return;
		}
		int rows = board.length;
		int cols = board[0].length;
		// 用一个虚拟节点，边界上的O的父节点都是这个虚拟节点
		UnionFind uf = new UnionFind(rows * cols + 1);
		int dummyNode = rows * cols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {// 边界
						uf.union(i * cols + j, dummyNode);
					} else {// 非边界的O就和周围的O连接
						if (i - 1 >= 0 && board[i - 1][j] == 'O') {
							uf.union(i * cols + j, (i - 1) * cols + j);
						}
						if (i + 1 < rows && board[i + 1][j] == 'O') {
							uf.union(i * cols + j, (i + 1) * cols + j);
						}
						if (j - 1 >= 0 && board[i][j - 1] == 'O') {
							uf.union(i * cols + j, i * cols + j - 1);
						}
						if (j + 1 < cols && board[i][j + 1] == 'O') {
							uf.union(i * cols + j, i * cols + j + 1);
						}
					}
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!uf.isConnection(i * cols + j, dummyNode)) {
					board[i][j] = 'X';
				}
			}
		}

	}

	public static void main(String[] args) {
		SolutionUF obj = new SolutionUF();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		obj.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

}
