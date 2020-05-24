package _641;
/**
 * 设计循环双端队列
 * @author xiaomeng
 *
 */
public class MyCircularDeque {
	
	int[] myQueue;
	int size;//当前队列大小
	int front;//头指针
	int rear;//尾指针
	int capacity;//队列容量
	
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
    	this.myQueue = new int[k];
    	this.size=0;
    	this.front=0;
    	this.rear=0;
    	this.capacity=k;

    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
    	//队满，插入失败
    	if(isFull())
    		return false;
    	front=(front-1+capacity)%capacity;
    	myQueue[front]=value;
    	size++;
    	return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if(isFull())
    		return false;
    	myQueue[rear] = value;
    	rear=(rear+1)%capacity;
    	size++;
    	return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
    	//队空
    	if(isEmpty())
    		return false;
    	front=(front+1)%capacity;
    	size--;
    	return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	if(isEmpty())
    		return false;
    	rear=(rear-1+capacity)%capacity;
    	size--;
    	return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
    	if(isEmpty())
    		return -1;
    	return myQueue[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    	if(isEmpty())
    		return -1;
    	int getR=myQueue[(rear-1+capacity)%capacity];
    	return getR;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
    	
    	return (front==rear) && (size==0);
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {

    	return (front==rear) && (size==capacity);
    }
    
    public static void main(String[] args) {
    	
    	 
    	MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
    	circularDeque.insertLast(1);			        // 返回 true
    	circularDeque.insertLast(2);			        // 返回 true
    	circularDeque.insertFront(3);			        // 返回 true
    	circularDeque.insertFront(4);			        // 已经满了，返回 false
    	circularDeque.getRear();  					// 返回 2
    	circularDeque.isFull();				        // 返回 true
    	circularDeque.deleteLast();			        // 返回 true
    	circularDeque.insertFront(4);			        // 返回 true
    	circularDeque.getFront();				// 返回 4

    	 
	}
}
