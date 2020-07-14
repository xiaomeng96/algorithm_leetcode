package _718;
/**
 * 718. 最长重复子数组
 * @author xm
 *
 */
public class Solution2 {
	/**
	 * 滑动窗口
	 *        1 2 3 2 1
	 *  3 2 1 7 4 5 6
	 *  
	 *    1 2 3 2 1
	 *  3 2 1 7 4 5 6
	 *  
	 * 1 2 3 2 1 
	 *   3 2 1 7 4 5 6
	 * @param A
	 * @param B
	 * @return
	 */
    public int findLength(int[] A, int[] B) {

    	return A.length < B.length ? findMax(A, B):findMax(B, A);
    	
    }
    public int findMax(int[] A, int[] B) {
    	int max = 0;
    	int an = A.length;
    	int bn = B.length;
    	for (int i = 1; i <= an; i++) {
			max = Math.max(max, MaxLen(A, 0, B, bn-i, i));
		}
    	
    	for(int j = bn-an-1; j>=0; j--) {
    		max = Math.max(max, MaxLen(A, 0, B, j, an));
    	}
    	
    	for (int i = 1; i < an; i++) {
			max = Math.max(max, MaxLen(A, i, B, 0, an-i));
		}
    	return max;
    	
    }
    public int MaxLen(int[] A, int i, int[] B, int j, int len) {
    	int count = 0, max = 0;
    	for (int k = 0; k < len; k++) {
			if(A[i+k] == B[j+k]) {
				count++;
			}else {
				count = 0;
			}
			max = Math.max(max, count);
		}
    	return max;
    }
	public static void main(String[] args) {
		Solution2 obj = new Solution2();
		int[] A = new int[] {1,2,3,2,1};
		int[] B = new int[] {3,2,1,4,7};
		System.out.println(obj.findLength(A, B));

	}

}
