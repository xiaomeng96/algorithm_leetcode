package _1122;

import java.util.Arrays;

/**
 * 1122. 数组的相对排序
 * @author xm
 *
 */
public class Solution {
	/**
	 * 桶排序/计数排序
	 * @param arr1
	 * @param arr2
	 * @return
	 */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

    	int[] bucket = new int[1001];//计数桶
    	for (int arr : arr1) {
			bucket[arr]++;
		}
    	//遍历arr2，获取元素的相对位置顺序
    	int idx = 0;
    	for (int arr : arr2) {
			while(bucket[arr] > 0) {
				arr1[idx++] = arr;
				bucket[arr]--;
			}
		}
    	//不在arr2中的元素，按照升序的顺序保存在结果数组中
    	for (int i = 0; i < bucket.length; i++) {
			while(bucket[i] > 0) {
				arr1[idx++] = i;
				bucket[i]--;
			}
		}
    	return arr1;
    	
    }
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr1 = new int[] {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = new int[] {2,1,4,3,9,6};
		int[] res = obj.relativeSortArray(arr1, arr2);
		for (int i : res) {
			System.out.print(i);
		}

	}

}
