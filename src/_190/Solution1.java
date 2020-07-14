package _190;
/**
 * 190. 颠倒二进制位
 * @author xm
 *
 */
public class Solution1 {
	/**
	 * 分治算法
	 * 将32位划分为左右两边各16位，进行交换
	 * 然后16位再划分为两个8位，交换
	 * ...
	 * 到2位划分为两个1位，交换
	 * @param n
	 * @return
	 */
	public int reverseBits(int n) {
		//>>>无符号左移
		n = (n >>> 16) | (n << 16);
		n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
		n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
		n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
		n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
		
		return n;
	}
	public static void main(String[] args) {
		Solution1 obj = new Solution1();
		System.out.println(obj.reverseBits(43261596));

	}

}
