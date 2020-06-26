package _589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 * @author xm
 *
 */
public class Solution {
	/**
	 * 递归
	 * 和二叉树的前序遍历一样
	 * @param root
	 * @return
	 */
    public List<Integer> preorder(Node root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root == null) {
    		return res;
    	}
    	helper(root, res);
    	return res;
        
    }
    public void helper(Node root, List<Integer> res) {
    	if(root == null){
    		return ;
    	}
    	res.add(root.val);
    	for (Node child : root.children) {
			helper(child, res);
		}
    	
    }
	public static void main(String[] args) {


	}

}
