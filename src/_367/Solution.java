package _367;

/**
 * 367. 有效的完全平方数
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * @author xm
 *
 */
public class Solution {
	/**
	 * 方法1：二分查找法
	 * 时间复杂度：O(logn)
	 */
    public boolean isPerfectSquare(int num) {
    	if(num < 2)
    		return true;
    	
    	long left=2, right=num/2, x, guess;
    	
    	while(left<=right) {
    		x=left+(right-left)/2;
    		guess=x*x;
    		if(guess == num) {
    			return true;
    		}else if(guess > num) {
    			right = x-1;
    		}else {
    			left = x+1;
    		}
    	}
    	return false;

    }
    
    /**
     * 方法2：牛顿迭代法
     * 近似解xk+1=（xk + num/xk）/2
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
    	if(num < 2)
    		return true;
    	
    	long x=num/2;
    	while(x*x > num) {
    		x = (x+num/x)/2;
    	}

    	return x*x == num;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		System.out.println(so.isPerfectSquare2(16));
		System.out.println(so.isPerfectSquare2(14));

	}

}
