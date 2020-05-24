package _299;

public class Solution {
	/**
	 * 299.猜数字游戏
	 * https://leetcode-cn.com/problems/bulls-and-cows/
	 * @param secret
	 * @param guess
	 * @return
	 */
	public static String getHint(String secret, String guess) {
		int[] bucket=new int[10];//标记数组，默认值为0
		int bull=0;//统计公牛个数
		int cow=0;//统计奶牛个数
		int n=secret.length();
		for (int i = 0; i < n; i++) {
			if(secret.charAt(i)==guess.charAt(i)) {
				//统计公牛数
				bull++;
				continue;
			}
			bucket[secret.charAt(i)-'0'] += 1;
			bucket[guess.charAt(i)-'0'] -= 1;
		}
		for (int i = 0; i < bucket.length; i++) {
			//统计secret中没有被猜到的数字个数
			if(bucket[i] > 0) {
				cow +=bucket[i];
			}
		}
		//secret中数字总个数-公牛数-没有被猜到的数字数
		cow = n-bull-cow;
		String res=bull+"A"+cow+"B";
		return res;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("2123", "0111"));
	}

}
