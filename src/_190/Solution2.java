package _190;

import javax.sound.midi.Soundbank;

/**
 * 190. 颠倒二进制位
 * @author xm
 *
 */
public class Solution2 {
	/**
	 * 总共32位
	 * n的第i位，即为颠倒后的第31-i为（i=0~31）
	 * (n&1)<<(31-i) 
	 * n = n >>> 1;无符号位移，正数和负数，高位都补0
	 * @param n
	 * @return
	 */
    public int reverseBits(int n) {
        int res = 0;
        int bit = 31;
        while(n!=0) {
        	res += (n&1)<<bit;
        	n = n >>> 1;
        	bit--;
        }
        return res;

    }
	public static void main(String[] args) {
		Solution2 obj = new Solution2();
		System.out.println(obj.reverseBits(43261596));

	}

}
