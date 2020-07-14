package _033;

/**
 * 33. 搜索旋转排序数组
 * @author xm
 *
 */
public class Solution {
	/**
	 * 二分搜索
	 * @param nums
	 * @param target
	 * @return
	 */
    public int search(int[] nums, int target) {
    	if(nums == null || nums.length == 0)
    		return -1;
    	
    	int low=0;
    	int high=nums.length-1;
    	while(low <= high) {//等号要带上
    		int mid = low + (high - low)/2;
    		if(target == nums[mid]) {
    			return mid;
    		}
    		if(nums[low] <= nums[mid]) {//左侧有序
    			if(nums[low] <= target && target < nums[mid]){//等号要带上
    				high = mid -1;
    			}else {
    				low = mid + 1;
    			}
    		}else {//右侧有序
    			if(nums[mid] < target && target <= nums[high]) {//等号要带上
    				low = mid+1;
    			}else {
    				high = mid-1;
    			}
    		}
    	}
    	//没有找到target
    	return -1;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution so=new Solution();
		int[] nums= {4,5,6,7,0,1,2};
		System.out.println(so.search(nums, 0));
		System.out.println(so.search(nums, 3));
		System.out.println(so.search(nums, 4));
		System.out.println(so.search(nums, 2));
	}

}
