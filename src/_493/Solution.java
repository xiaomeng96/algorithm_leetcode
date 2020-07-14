package _493;
/**
 * 493. 翻转对
 * @author xm
 *
 */
public class Solution {
	/**
	 * 归并排序
	 * 举例画归并图看
	 * @param nums
	 * @return
	 */
    public int reversePairs(int[] nums) {

    	return mergeSortAndCount(nums, 0, nums.length-1);
    }
    
    public int mergeSortAndCount(int[] nums, int start, int end) {
    	
    	if(start < end) {
    		int mid = (start + end) / 2;
    	    //划分
    		int count = mergeSortAndCount(nums, start, mid) + mergeSortAndCount(nums, mid+1, end);
    		//计算翻转对个数
    		int j = mid + 1;
    		for (int i = start; i <= mid; i++) {
				while(j <= end && (long)nums[i] > 2*(long)nums[j]) {
					j++;
				}
				count += j - (mid+1);
			}
    		//归并
    		merge(nums, start, mid, end);
    		return count;
    	
    	}else {
    		return 0;
    	}
    }
    //合并两个有序数组
    public void merge(int[] nums, int start, int mid, int end) {
    	int n1 = mid- start + 1;//包含mid
    	int n2 = end - mid;
    	int[] L = new int[n1];
    	int[] R = new int[n2];
    	for (int i = 0; i < n1; i++) {
			L[i] = nums[start + i];
		}
    	for (int j = 0; j < n2; j++) {
			R[j] = nums[mid+1+j];
		}
    	
    	int i=0, j=0;
    	for (int k = start; k <= end; k++) {
			if(j >= n2 || (i < n1 && L[i] < R[j])) {
				nums[k] = L[i++];
			}else {
				nums[k] = R[j++];
			}
		}
    	
    }
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.reversePairs(new int[] {1,3,2,3,1}));
		System.out.println(obj.reversePairs(new int[] {2,4,3,5,1}));

	}

}
