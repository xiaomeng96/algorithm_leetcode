package _434;

/**
 * 434. 字符串中的单词数
 * @author xiaomeng
 *
 */
public class Solution {

	/**
	 * 时间复杂度O(n)；空间复杂度O(n)
	 * @param s
	 * @return
	 */
	public int countSegments1(String s) {
		String trimmed=s.trim();//去掉s开头的空格
		if(trimmed.equals(""))
			return 0;
		// \s表示匹配任何空白字符，+表示匹配一次或多次
		return s.split("\\s+").length;
    }
	
	/**
	 * 时间复杂度O(n);空间复杂度O(1)
	 * @param s
	 * @return
	 */
	public int countSegments2(String s) {
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			if((i==0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		String s="Hello, my name is John";
		System.out.println(so.countSegments1(s));
		String s2="   1";
		System.out.println(so.countSegments2(s2));
	}

}
