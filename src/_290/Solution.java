package _290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/**
	 * 290. 单词规律
	 * 解题思路：
	 * 1.用split将str分割成字符串数组s
	 * 2.如果pattern中字符个数与s.length不相等，说明无法一一对应，返回false
	 * 3.当pattern.charAt(i)字符还没有对应的字符串时，判断s[i]是否有其他对应关系，如果有，返回false；否则，构建对应关系
	 * 4.当pattern.charAt(i)字符有对应的字符串时，判断其对应的字符串是否和s[i]相等，不是就返回false
	 * 5.当遍历完pattern，说明都匹配
	 * @param pattern
	 * @param str
	 * @return
	 */
	public static boolean wordPattern(String pattern, String str) {
		//校验参数
		if(pattern == null || str == null)
			return false;
		String[] s=str.split(" ");//以空格划分str
		if(pattern.length() != s.length)//对应的长度不匹配
			return false;
		
		Map<Character, String> map= new HashMap<>();//构建字符和字符串的映射
		for (int i = 0; i < pattern.length(); i++) {
			Character tmp=pattern.charAt(i);
			if(map.containsKey(tmp)) {//tmp字符有映射
				if(!map.get(tmp).equals(s[i]))//tmp字符对应的字符串不是string[i]，不匹配
					return false;
			}else {//tmp字符没有映射
				if(map.containsValue(s[i])){//string[i]已经被使用，不匹配
					return false;
				}else {
					map.put(tmp, s[i]);
				}				
			}
		}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
		System.out.println(wordPattern(null, null));
	}

}
