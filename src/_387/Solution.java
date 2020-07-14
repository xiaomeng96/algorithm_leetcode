package _387;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * @author xm
 *
 */
public class Solution {
	/**
	 * 哈希表
	 * @param s
	 * @return
	 */
    public int firstUniqChar(String s) {

    	//当字符数量较小的时候，可以采用数组来代替哈希表
//    	int[] count = new int[26];
    	HashMap<Character, Integer> map = new HashMap<>();
    	//统计s中每个字符出现的次数
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
    	
    	//再从头开始遍历，当出现字符个数为1时，返回其下标
    	for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if(map.get(c) == 1) {
				return j;
			}
		}
    	//不存在不重复的字符
    	return -1;
    }
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.firstUniqChar("leetcode"));
		System.out.println(obj.firstUniqChar("loveleetcode"));

	}

}
