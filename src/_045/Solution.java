package _045;
/**
 * 45. 跳跃游戏 II
 * @author xm
 *
 */
public class Solution {
	/**
	 * 贪心算法
	 * 每次在可跳的范围内选择可以跳的更远的位置
	 * @param nums
	 * @return
	 */
    public int jump(int[] nums) {
    	if(nums.length == 0)
    		return 0;
    	int end=0;//设定一个边界
    	int maxPosition = 0;
    	int step=0;
    	//i < nums.length-1，当最后一步最远可达距离恰好到达最后一个位置，step会多加1
    	for (int i = 0; i < nums.length-1; i++) {
			maxPosition = Math.max(maxPosition, nums[i] + i);
			if(i==end) {//当走到了最远的边界，更新边界，步数加一
				end = maxPosition;
				step++;
			}
		}
    	return step;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		System.out.println(so.jump(new int[] {2,3,1,1,4}));
		System.out.println(so.jump(new int[] {}));

	}

}
