package _091;
/**
 * 91. 解码方法
 * @author xm
 *
 */
public class Solution {
	/**
	 * 动态规划
	 * 1.状态定义
	 *     dp[i]：以s[i-1]为结尾的前缀子串有多少种解码方法
	 * 2.状态转移方程
	 *     若s[i] == '0' ，字符 s[i] 就不能单独解码，所以当 s[i] != '0' 时，dp[i+1] = dp[i] * 1；（s[i]单独解码的情况）
	 *     若10 <= int(s[i..i+1]) <= 26，即 dp[i+1] += dp[i - 1] * 1；（s[i]和是s[i-1]合并解码的情况）
	 * 3.初始化
	 *     dp[0] = 1, dp[1] = 1
	 * 4.返回值
	 * 	   dp[len]
	 * @param s
	 * @return
	 */
    public int numDecodings(String s) {
    	//参数检验
    	int len = s.length();
    	if(len == 0 || s.charAt(0) == '0') {
    		return 0;
    	}
    	
    	int[] dp = new int[len+1];
    	dp[0] = 1;
    	dp[1] = 1;
    	for (int i = 1; i < len; i++) {
			if(s.charAt(i) != '0') {
				dp[i+1] = dp[i];//s[i]单独解码
			}
			int num = 10*(s.charAt(i-1) - '0') + s.charAt(i) - '0';
			if(num >= 10 && num <= 26) {
				dp[i+1] += dp[i-1];//s[i]和s[i-1]合并解码
			}
		}
    	return dp[len];

    }
    /*
     * dp[i]仅与前两项有关，使用单变量来代替dp数组
     */
    public int numDecodings2(String s) {
    	//参数检验
    	int len = s.length();
    	if(len == 0 || s.charAt(0) == '0') {
    		return 0;
    	}
    	
    	int pre = 1, cur = 1;

    	for (int i = 1; i < len; i++) {
    		int tmp = cur;
    		if(s.charAt(i) == '0') {//不能单独解码
    			if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2')
    				cur = pre;
    			else
    				return 0;
    		}else {
    			int num = 10*(s.charAt(i-1) - '0') + s.charAt(i) - '0';
    			if(num >= 10 && num <= 26) {//即可单独解码，也可以合并解码
    				cur += pre;
    			}
    		}
			
			pre = tmp;
		}
    	return cur;

    }
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.numDecodings("1200"));
		System.out.println(so.numDecodings2("12120"));
		System.out.println(so.numDecodings2("226"));
		System.out.println(so.numDecodings2("127"));
	}

}
