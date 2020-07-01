package _547;
/*
 * 方法3：并查集Union-Find
 */
class UF{
	//连通分量的数量
	private int count;
	private int[] parent;//存储每个节点根节点
	private int[] size;//存储以每棵子树的节点个数
	public UF(int n){
		count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;//初始化的时候每个节点都是以自己为根节点
			size[i] = 1;//每棵树的节点个数都为1
		}
	}
	//连接两棵树
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP == rootQ) {//节点p, 节点q的根节点相同的话，说明已经连通
			return ;
		}
		//让小树连接到大树的下面，让树更平衡
		if(size[rootP] > size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		count--;
	}
	//判断两个节点是否连通
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
		
	}
	//返回某个节点x的根节点
	public int find(int x) {
		while(parent[x] != x) {//当x的根节点不是自己的时候，让x指向最终的根节点
			parent[x] = parent[parent[x]];//进行路径压缩，使得查找时间复杂度为logN
			x = parent[x];
		}
		return x;
	}
	//返回当前连通分量的个数
	public int getCount() {
		return count;
	}

}
public class SolutionUF {
	/**
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
		int n = M.length;//总共的人数
		UF uf = new UF(n);//并查集初始化
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(M[i][j] == 1) {//两个人是朋友，就连接起来
					uf.union(i, j);
				}
			}
		}
		return uf.getCount();
	}
	public static void main(String[] args) {
		SolutionUF obj = new SolutionUF();
		int[][] M = new int[][] {{1,1,0},
			{1,1,0},
			{0,0,1}};
		System.out.println(obj.findCircleNum(M));	

	}

}
