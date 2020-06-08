package _017m;

/**
 * 面试题 17.09. 第 k 个数
 * @author xiaomeng
 *
 */
public class Solution {

	/**
	 * 动态规划
	 * @param k
	 * @return
	 */
    public int getKthMagicNumber(int k) {
    	int[] res=new int[k];
    	//定义三个指针p3,p5,p7；p3指向的数只能乘以3，p5,p7以此类推
    	int p3=0,p5=0,p7=0;
    	res[0] = 1;//第一个丑数
    	for (int i = 1; i < k; i++) {
    		//选取这三个数中最小的数，作为新的丑数
			res[i] = Math.min(3*res[p3], Math.min(5*res[p5], 7*res[p7]));
			if(res[i] == 3*res[p3])
				p3++;
			if(res[i] == 5*res[p5])
				p5++;
			if(res[i] == 7*res[p7])
				p7++;	
		}

    	return res[k-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution so=new Solution();
		System.out.println(so.getKthMagicNumber(5));
	}

}
