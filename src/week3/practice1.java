package week3;


/**
 * 作业：使用二分查找，寻找一个半有序数组中间无序的地方
 * 返回值是无序的起始位置，例如 [4, 5, 6, 7, 0, 1, 2]，返回值为4
 * @author xm
 *
 */
public class practice1 {
	
	public int findDisorder(int[] nums) {
		if(nums.length == 0)
			return -1;
		//数组有序的话就返回-1
		if(nums[0] < nums[nums.length-1])
			return -1;
		int l=0, h=nums.length-1;
		while(l < h) {
			int mid = l+(h-l)/2;
			if(nums[mid] > nums[mid+1]) {
				return mid + 1;
			}
			if(nums[mid-1] > nums[mid]) {
				return mid;
			}
			if(nums[0] < nums[mid]) {//左半部分有序，有半部分无序
				l=mid+1;
			}else {//左半部分无序，右半部分有序
				h=mid-1;
			}					
		}
		return -1;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		practice1 p=new practice1();
		int[][] nums= {{4, 5, 6, 7, 0, 1, 2},
				{1,2,3,4},
				{6, 5},
				{2,3,4,5,1},
				{5,1,2,3,4}};
		for (int[] num : nums) {
			System.out.println(p.findDisorder(num));
		}
	}

}
