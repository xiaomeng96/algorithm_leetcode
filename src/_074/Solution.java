package _074;

/**
 * 74. 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author xm
 *
 */
public class Solution {
	/**
	 * 二分法
	 * 矩阵可以转化为一个有序的数组，采用二分查找
	 * @param matrix
	 * @param target
	 * @return
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0)
    		return false;
    	int m=matrix.length;
    	int n=matrix[0].length;
    	
    	int left=0;
    	int right=m*n-1;
    	while(left <= right) {
    		int mid=left + (right - left)/2;
    		int num=matrix[mid/n][mid%n];
    		if(target == num) {
    			return true;
    		}else if(target < num) {
    			right = mid -1;
    		}else {
    			left = mid + 1;
    		}
    		
    	}
    	return false;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[][] matrix= {{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}};
		System.out.println(so.searchMatrix(matrix, 3));
		System.out.println(so.searchMatrix(matrix, 13));

	}

}
