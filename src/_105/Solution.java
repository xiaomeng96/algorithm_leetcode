package _105;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @author xm
 *
 */
public class Solution {
	/**
	 * 递归
	 * @param preorder
	 * @param inorder
	 * @return
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int n = preorder.length;
    	if(n == 0) {
    		return null;
    	}else if(n == 1) {//只有一个根节点
    		return new TreeNode(preorder[0]);
    	}
    	
		TreeNode root = new TreeNode(preorder[0]);
		for(int i = 0; i < n ; i++) {
			//找到中序中对应的根节点位置，通过根节点位置将前序、中序序列划分出左右子树
			if(preorder[0] == inorder[i]) {
				int[] preLeft = Arrays.copyOfRange(preorder, 1, i+1);
				int[] preRight = Arrays.copyOfRange(preorder, i+1, n);
				int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
				int[] inRight = Arrays.copyOfRange(inorder, i+1, n);
				root.left = buildTree(preLeft, inLeft);
				root.right = buildTree(preRight, inRight);
				break;
			}
		}
    	return root;
    	

    }
	public static void main(String[] args) {
		Solution so=new Solution();
		int[] pre = {3,9,20,15,7};
		int[] in = {9,3,15,20,7};
		System.out.println(so.buildTree(pre, in));
		

	}

}
