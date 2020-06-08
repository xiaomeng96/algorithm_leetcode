package _015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author xiaomeng
 *
 */
public class Solution {

	/**
	 * 两数之和（哈希表），由浅入深到，三数之和
	 * 双指针
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res=new ArrayList<>();
    	int n=nums.length;
    	//参数校验
    	if(nums == null || n<3)
    		return res;
    	
    	Arrays.sort(nums);//先排序
    	
    	for (int i = 0; i < n; i++) {
			if(nums[i]>0)//nums排好序的，第一个数大于0，后面就不可能为0
				break;
			//去重
			if(i>0 && nums[i] == nums[i-1])
				continue;
			int l=i+1;
			int r=n-1;
			while(l<r) {
				int sum=nums[i] + nums[l] + nums[r];
				if(sum == 0) {
					res.add(Arrays.asList(nums[i], nums[l], nums[r]));
					while(l<r && nums[l] == nums[l+1]) //去重
						l++;
					while(l<r && nums[r] == nums[r-1])//去重
						r--;
					l++;
					r--;
				}else if(sum < 0) {
					l++;
				}else {
					r--;
				}
			}
			
		}
    	return res;

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums= {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = so.threeSum(nums);
		System.out.println(res.size());
		for (List<Integer> list : res) {
			System.out.println(list);
		}
		
	}

}
