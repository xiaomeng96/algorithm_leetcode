package _074;

public class Solution2 {

	public boolean searchMatrix(int[][] matrix, int target) {
		
		if(matrix.length == 0) {
			return false;
		}
		
		int r=0;
		int c=matrix[0].length-1;
		while(r < matrix.length && c >= 0) {
			if(matrix[r][c] == target) {
				return true;
			}else if(matrix[r][c] > target) {
				c--;
			}else {
				r++;
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
