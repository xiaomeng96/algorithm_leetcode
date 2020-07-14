package _153;
/**
 * 153. 寻找旋转排序数组中的最小值
 * @author xm
 *
 */
public class Solution {
	/**
	 * 二分搜索
	 * @param nums
	 * @return
	 */
    public int findMin(int[] nums) {
    	if(nums.length == 1) {
    		return nums[0];
    	}
    	
    	int left = 0;
    	int right = nums.length-1;

    	while(left < right) { 		
    		int mid = left + (right-left)/2;
    		if(nums[mid] > nums[right]) {
    			left = mid+1;
    		}else {
    			right = mid;
    		}
    	}
    	//没有找到
    	return nums[left];

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution so=new Solution();
		System.out.println(so.findMin(new int[] {3,4,5}));
		System.out.println(so.findMin(new int[] {7, 6}));
		System.out.println(so.findMin(new int[] {7, 6, 5, 4}));
		System.out.println(so.findMin(new int[] {3,1, 2}));
	}

}
