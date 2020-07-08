package _191;

public class Solution2 {
	/**
	 * 方法2：int类型为32位，将n与mask做逻辑与
	 * mask的初始值为1，后面左移32次，分别获得n的每一位的值
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {
		int mask = 1;
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if((n & mask) != 0) {//n的当前位是1，计数
				count++;
			}
			mask <<= 1;//左移一位
		}
		return count;
		
	}
	public static void main(String[] args) {
		Solution2 obj = new Solution2();
		System.out.println(obj.hammingWeight(11));
		System.out.println(obj.hammingWeight(-3));

	}

}
