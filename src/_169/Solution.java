package _169;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * @author xm
 *
 */
public class Solution {

	/**
	 * 方法1：哈希表
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	private Map<Integer, Integer> countNum(int[] nums){//统计nums中每个元素出现的次数
		Map<Integer, Integer> count=new HashMap<>();
		for (int num : nums) {
			if(!count.containsKey(num)) {
				count.put(num, 1);
			}else {
				count.put(num, count.get(num)+1);
			}
		}
		return count;
	}
	
    public int majorityElement(int[] nums) {
    	Map<Integer, Integer> count=countNum(nums);
    	
    	Map.Entry<Integer, Integer> majorityEntry = null;
    	for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			if(entry.getValue() > nums.length/2) {
				majorityEntry = entry;
			}
		}
    	return majorityEntry.getKey();

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
