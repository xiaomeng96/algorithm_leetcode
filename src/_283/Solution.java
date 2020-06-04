package _283;

/**
 * 283. 移动零
 * @author xiaomeng
 *
 */
public class Solution {
	/**
	 * 时间复杂度O(n)；空间复杂度O(1)
	 * @param nums
	 */
    public void moveZeroes(int[] nums) {
    	if(nums == null)
    		return;
    	
    	int j=0;//通过j来统计非零数字的个数
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
    	//剩余的位置就补充0
    	for (int i = j; i < nums.length; i++) {
			nums[i]=0;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums= {0,1,0,3,12};
		so.moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
