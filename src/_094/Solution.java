package _094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * @author xiaomeng
 *
 */
public class Solution {
	
	/**
	 * 方法一：递归
	 * 时间复杂度：O(n)。递归函数T(n)=2*T(n/2)+1。
	 * 空间复杂度：最坏的情况是O(n)；最好的情况：O(logn)，树平衡的时候
	 * @param root
	 * @return
	 */
    public List<Integer> inorderTraversal(TreeNode root) {

    	List<Integer> res = new ArrayList<Integer>();
    	if(root != null)
    		helper(res, root);
    	return res;
    }
    
    public void helper(List<Integer> res, TreeNode root) {
    	if(root.left != null) {//左
    		helper(res, root.left);
    	}
    	res.add(root.val);//中
    	if(root.right != null) {//右
    		helper(res, root.right);
    	}
    }
    
    /**
     * 方法2：借助栈的迭代方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
    	
    	List<Integer> res =new ArrayList<Integer>(); 
    	Stack<TreeNode> stack = new Stack<>();
    	
    	TreeNode curr=root;
    	while(curr!=null || !stack.isEmpty()) {
    		while(curr != null) {
    			stack.add(curr);
    			curr = curr.left;
    		}
    		curr = stack.pop();
    		res.add(curr.val);
    		curr=curr.right;		
    	}
    	return res;
    }
}
