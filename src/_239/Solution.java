package _239;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 * @author xiaomeng
 *
 */
public class Solution {
	
	ArrayDeque<Integer> deq=new ArrayDeque<Integer>();
	int[] nums;
	
	public void cleanDeque(int i, int k) {
		//清除队列中滑出当前窗口的值的索引
		if(!deq.isEmpty() && deq.getFirst()==i-k) {
			deq.removeFirst();
		}
		//清除队列中比当前i对应的值要小的值的索引
		while(!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
			deq.removeLast();
		}
	}
	
	/**
	 * 方法一：双端队列
	 * 允许我们在队列的头尾两端都能在 O(1)的时间内进行数据的查看、添加和删除。
	 * 最常用的地方：实现一个长度动态变化的窗口或者连续区间
	 * @param nums：给定的数组
	 * @param k：滑动窗口内数字个数
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		
		//参数校验
		int n=nums.length;
		if(n==0 || k<=0)
			return new int[0];
		if(k==1)
			return nums;
		
		this.nums=nums;//nums是类的属性，要初始化
		int[] res=new int[n-k+1];//定义结果数组
//		int max_id=0;//窗口内最大值索引
		for(int i=0;i<k;i++) {
			cleanDeque(i, k);
			deq.add(i);
		}
		res[0] = nums[deq.getFirst()];
		
		for(int i=k;i<n;i++) {
			cleanDeque(i, k);
			deq.add(i);
			res[i-k+1] = nums[deq.getFirst()];
		}
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] arr= new int[]{1,3,-1,-3,5,3,6,7};
		int k=3;
		int[] res=so.maxSlidingWindow(arr, k);
		for (int num : res) {
			System.out.print(num + " ");
		}
		
	}

}
