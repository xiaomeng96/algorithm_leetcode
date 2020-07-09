package _146;

class Node{
	public int key, val;
	public Node pre;
	public Node next;
	Node(int key, int val){
		this.key  = key;
		this.val = val;
	}
}

public class DLinkedList {
	
	private Node head, tail;
	private int size;
	public DLinkedList() {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		size = 0;
		head.next = tail;
		tail.pre = head;
	}
	
	//在链表的头部添加节点
	public void addFirst(Node x) {
		x.pre = head;
		x.next = head.next;
		head.next.pre = x;
		head.next = x;
		size++;
	}
	//删除节点（该节点一定存在）
	public void remove(Node x) {
		x.next.pre = x.pre;
		x.pre.next = x.next;
		size--;
	}
	//删除最后一个节点并返回该节点
	public Node removeLast() {
		if(head.next == tail) {
			return null;
		}
		Node last = tail.pre;
		remove(last);
		return last;
	}
	
	public int getSize() {
		return size;
	}

}
