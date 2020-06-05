package _068;

/**
 * 面试题68 - II. 二叉树的最近公共祖先（236）
 * @author xiaomeng
 *
 */
public class Solution {
	//递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口
    	if(root == null || root == p || root==q) {
    		return root;
    	}
    	//左子节点递归
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	//右子节点递归
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	
    	if(left == null)//left为空，说明p,q在root的右子树中
    		return right;
    	if(right == null)//right为空，说明p,q在root的左子树中
    		return left;
    	//都不为空，说明p,q在root的两侧
    	return root;
    	
    }
}
