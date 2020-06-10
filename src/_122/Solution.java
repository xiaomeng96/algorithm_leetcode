package _122;

/**
 * 122. 买卖股票的最佳时机 II
 * @author xiaomeng
 *
 */
public class Solution {
	
	/**
	 * 贪心算法
	 * 利润为正的话，就一直买
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
    	int profit=0;
    	for (int i = 1; i < prices.length; i++) {
			int tmp=prices[i] - prices[i-1];
			if(tmp>0)
				profit += tmp;
		}
        return profit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(so.maxProfit(prices));
		int[] prices2 = {1,2,3,4,5};
		System.out.println(so.maxProfit(prices2));

	}

}
