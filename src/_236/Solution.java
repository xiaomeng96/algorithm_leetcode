package _236;
/**
 * 236. 二叉树的最近公共祖先
 * @author xm
 *
 */
public class Solution {
	/**
	 * 三种情况：
	 * 1.p,q位于root两侧
	 * 2.p为root，q在p的左或右子树中
	 * 3.q为root，p在q的左或右子树中
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	//当root到达叶子节点的下层或者p，q时
    	if(root == null || root == p || root == q) {
    		return root;
    	}
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	
    	if(left != null && right != null) {//1.左右子树中都找到了，说明p，q位于root两侧
    		return root;
    	}else if(left == null) {//2.左子树没有找到，p，q就在右子树中
    		return right;
    	}else if(right == null) {//3.右子树没有找到，p，q就在左子树中
    		return left;
    	} 	
    	return null;
    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
