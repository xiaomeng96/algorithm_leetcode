package _169;

public class Solution3 {
	/**
	 * 方法3：Boyer-Moore 投票算法
	 * 理论：多数元素的个数总和  - 少数元素的个数总和>=1
	 * 1.候选人初始化为nums[0]，票数初始化为1；
	 * 2.当遇到相同的候选人时，票数+1，否则票数-1；
	 * 3.当票数为0时，更换候选人，并将票数重置为1
	 * 
	 * 时间复杂度O(n)
	 * 空间复杂度O(1)
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		int count=0;
		Integer candidate=null;
		for (int num : nums) {
			if(count == 0) {
				candidate=num;
			}
			if(candidate == num) {
				count += 1;
			}else {
				count -= 1;
			}
		}
		
		return candidate;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums= {3, 2, 3};
		System.out.println(so.majorityElement(nums));
		int[] nums2= {2,2,1,1,1,2,2};
		System.out.println(so.majorityElement(nums2));
	}

}
