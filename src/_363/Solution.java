package _363;
/**
 * 363. 矩形区域不超过 K 的最大数值和
 * @author xm
 *
 */
public class Solution {
	/**
	 * 数组滚动法
	 * 时间复杂度为O(mn2)，空间复杂度O(m)
	 * 采用暴力法和动态规划的方法，时间复杂度为O(m2n2)，空间O(mn)
	 * @param matrix
	 * @param k
	 * @return
	 */
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
    	
    	for(int l = 0; l < cols; l++) {//l为左边界，从0开始
    		int[] rowSum = new int[rows];//rowSum数组，记录两个边界中间的每一行的和
    		for(int r = l; r < cols; r++) {//r为列的右边界
    			for(int i = 0; i < rows; i++) {
    				rowSum[i] += matrix[i][r];
    			}
    			
    			//求rowSum连续子数组的最大和
    			//和尽量打，但不大于k
    			max = Math.max(max, dpmax(rowSum, k));
    			if(max == k) return k;
    		}
    	}
    	return max;

    }
    //求连续子数组最大和，但不大于k
    private int dpmax(int[] arr, int k) {
    	int sum = arr[0], maxSum = sum;
    	for (int i = 1; i < arr.length; i++) {
			if(sum > 0) {
				sum += arr[i];
			}else {
				sum = arr[i];
			}
			maxSum = Math.max(maxSum, sum);
		}
    	
    	if(maxSum <= k)
    		return maxSum;
    	//前面没有找到不大于k的连续子序和，采用暴力法
    	int max = Integer.MIN_VALUE;
    	for(int l = 0; l < arr.length; l++) {
    		int s = 0;
    		for(int r = l; r < arr.length; r++) {
    			s += arr[r]; 
    			if(s > max && s <= k) {
    				max = s;
    			}
    			if(max == k)//尽量提前返回
    				return max;
    		}
    	}
    	return max;
    }
	public static void main(String[] args) {
		Solution so = new Solution();
//		int[][] matrix = {{1, 0, 1}, {0, 2, -3}};
		int[][] matrix = {{2, 2, -1}};
		System.out.println(so.maxSumSubmatrix(matrix, 0));

	}

}
