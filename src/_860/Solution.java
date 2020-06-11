package _860;
/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/
 * @author xiaomeng
 *
 */
public class Solution {
	/**
	 * 模拟现实情况（贪心算法）
	 * 顾客给5块时，收下；
	 * 顾客给10块时，找零5块
	 * 顾客给20块时，可以返还一个10块和一个5块，也可以返还3个5块
	 * @param bills
	 * @return
	 */
	public boolean lemonadeChange(int[] bills) {
		int five=0,ten=0;
		for (int bill : bills) {
			if(bill == 5) {
				five++;
			}else if(bill == 10) {
				if(five > 0) {
					five--;
					ten++;
				}
					
				else
					return false;
			}else if(bill == 20) {
				if( five > 0 && ten > 0) {
					five--;
					ten--;
				}else if(five >= 3) {
					five -= 3;
				}else {
					return false;
				}
			}
		}
		return true;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution so=new Solution();
		int[] bills = {5,5,5,10,20};
		System.out.println(so.lemonadeChange(bills));
		int[] bills2 = {5,5,10};
		System.out.println(so.lemonadeChange(bills2));
		int[] bills3 = {10,10};
		System.out.println(so.lemonadeChange(bills3));
	}

}
