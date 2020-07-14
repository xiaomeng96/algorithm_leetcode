package _024;
/**
 * 24. 两两交换链表中的节点
 * @author xm
 *
 */
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}
public class Solution {

	/**
	 * 方法1：递归
	 * @param head
	 * @return
	 */
    public ListNode swapPairs(ListNode head) {

    	if(head == null || head.next == null) {
    		return head;
    	}
    	ListNode first = head;
    	ListNode second = head.next;
    	first.next = swapPairs(second.next);
    	second.next = first;
    	return second;
    }
    
    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
    	//建立一个空的头节点
    	ListNode pre = new ListNode(0);
    	pre.next = head;
    	ListNode tmp = pre;//采用临时节点，避免遍历链表的时候找不到头节点
    	while(tmp.next != null && tmp.next.next != null) {
    		ListNode first = tmp.next;
    		ListNode second = tmp.next.next;
    		tmp.next = second;
    		first.next = second.next;
    		second.next = first;
    		tmp = first;
    		
    	}
    	return pre.next;
    	
    }
    

}
