package _231;
/**
 * 231. 2的幂
 * @author xm
 *
 */
public class Solution {
	/**
	 * 方法1：n&(n-1)将n最右边的1变为0
	 * 当n为2的幂时，二进制只有一个1
	 * 1：0001
	 * 2：0010
	 * 4：1000
	 * @param n
	 * @return
	 */
    public boolean isPowerOfTwo(int n) {
    	long x = (long) n;
    	return x > 0 && (x & (x-1)) == 0;

    }
    /**
     * 方法2：n&(-n) == n
     * -n = ~n+1
     * n&(-n)保留n中最右边的一个1
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
    	if(n == 0)
    		return false;
    	long x = (long) n;
    	return (x & (-x)) == x;
    	
    }
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.isPowerOfTwo2(1));
		System.out.println(obj.isPowerOfTwo2(16));
		System.out.println(obj.isPowerOfTwo2(218));

	}

}
