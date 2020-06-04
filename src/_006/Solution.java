package _006;

import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 * 方法2更优
 * @author xiaomeng
 *
 */
public class Solution {
	/**
	 * 方法1：借助栈（Stack）或者ArrayList
	 * 时间复杂度O(n);空间复杂度O(n)
	 * @param head
	 * @return
	 */
    public int[] reversePrint(ListNode head) {
    	
    	if(head == null)
    		return new int[0];
    	
    	Stack<Integer> stack=new Stack<>();
    	ListNode curNode=head;
    	while(curNode != null) {
    		stack.push(curNode.val);
    		curNode = curNode.next;
    	}
    	
    	int size=stack.size();
    	int[] res = new int[size];
    	for (int i = 0; i < size; i++) {
			res[i] = stack.pop();
		}
    	
    	return res;
    	
    }
    
    /**
     * 方法2：不借助栈和ArrayList
     * 时间复杂度O(n)， 空间复杂度O(1)
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
    	if(head == null)
    		return new int[0];
    	
    	int size=0;
    	ListNode curNode = head;
    	while(curNode != null) {
    		size++;
    		curNode = curNode.next;
    	}
    	
    	int[] res = new int[size];
    	while(head != null) {
    		res[size - 1] = head.val;
    		head = head.next;
    		size--;
    	}
    	return res;
    }

}
