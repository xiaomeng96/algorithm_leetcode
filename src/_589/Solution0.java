package _589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution0 {
	/**
	 * 迭代
	 * @param root
	 * @return
	 */
	public List<Integer> preorder(Node root){
		List<Integer> res = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<>();
		if(root == null) {
			return res;
		}
		//加入根节点
		stack.add(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			res.add(node.val);
			List<Node> children = node.children;
			int size = children.size();
			//遍历根节点的孩子，逆序（从右往左依次加入孩子节点到栈）
			for (int i = size-1; i >= 0; i--) {
				stack.add(children.get(i));
			}
		}
		return res;
	}
}
