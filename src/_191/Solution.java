package _191;
/**
 * 191. 位1的个数
 * @author xm
 *
 */
public class Solution {
	/**
	 * 方法1：n&(n-1)可以把n的最低位1变为0
	 * @param n
	 * @return
	 */
    public int hammingWeight(int n) {
    	int count = 0;
        while(n!=0) {
        	n &= (n-1);
        	count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.hammingWeight(11));
		System.out.println(obj.hammingWeight(-3));

	}

}
