package _055;

/**
 * 55. 跳跃游戏
 * @author xm
 *
 */
public class Solution {
	/**
	 * 贪心算法
	 * 保留一个当前可以到达的最远位置，每走一步，就比较该位置可以到达的最远距离是否超过保留的最远位置
	 * 若是，就更新可以到达的最远位置；
	 * @param nums
	 * @return
	 */
    public boolean canJump(int[] nums) {
    	if(nums == null || nums.length==0)
    		return false;
    	
    	int n=nums.length;
    	int maxDis=0;
    	for (int i = 0; i < n; i++) {
    		if(i <= maxDis) {
    			//i+nums[i]相当于从原点开始可以达到的最大位置
    			maxDis = Math.max(maxDis, i+nums[i]);
    			if(maxDis >= n-1)//大于等于最后一个位置，返回true
    				return true;
    		}else {
    			return false;
    		}
			
		}

    	return false;
    }
    
    //逆着推
    public boolean canJump2(int[] nums) {
    	if(nums == null || nums.length==0)
    		return false;
    	
    	int n=nums.length;
    	int lastPosition=n-1;
    	for(int i=n-1; i>=0; i--) {
    		if(nums[i]+i >= lastPosition) {
    			lastPosition=i;
    		}
    	}
    	return lastPosition == 0;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] nums= {3,2,1,0,4};
		int[] nums2= {2, 3, 1, 1, 4};
		System.out.println(so.canJump2(nums));
		System.out.println(so.canJump2(nums2));

	}

}
