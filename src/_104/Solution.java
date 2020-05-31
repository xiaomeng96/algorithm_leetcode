package _104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * @author xiaomeng
 *
 */
public class Solution {

	/*
	 * 方法一：递归DFS
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 */
    public int maxDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	//返回左子树的最大深度
    	int leftMaxDepth = maxDepth(root.left);
    	//返回右子树的最大深度
    	int rightMaxDepth = maxDepth(root.right);
    	return Math.max(leftMaxDepth, rightMaxDepth)+1;
  
    }
    
    /*
     * 方法二：BFS
     * 时间复杂度：O(n)
     * 空间复杂度：线性表最差O(n)，二叉树完全平衡最好O(logn)
     */
    public int maxDepth2(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	//定义一个队列
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.add(root);
    	int maxDepth=0;
    	while(!queue.isEmpty()) {
    		maxDepth++;
    		int size=queue.size();
    		for (int i = 0; i < size; i++) {
				TreeNode node=queue.poll();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
    	}
    	return maxDepth;
  
    }

}
