package _455;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * @author xm
 *
 */
public class Solution {
	/**
	 * 贪心算法
	 * 选择尺寸尽可能小的且又能够满足孩子的饼干
	 * @param g 孩子的胃口值
	 * @param s 饼干尺寸
	 * @return
	 */
    public int findContentChildren(int[] g, int[] s) {
    	int gi=0, sj=0;
    	//先排序
    	Arrays.sort(g);
    	Arrays.sort(s);
    	while(gi<g.length && sj<s.length) {
    		if(g[gi] <= s[sj]) {
    			gi++;
    		}
    		sj++;
    	}
    	return gi;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] g= {1,2,3};
		int[] s= {1,1};
		System.out.println(so.findContentChildren(g, s));
		int[] g2= {1,2};
		int[] s2= {1,2, 3};
		System.out.println(so.findContentChildren(g2, s2));
		

	}

}
