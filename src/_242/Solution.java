package _242;
/**
 * 242. 有效的字母异位词
 * s和t字母顺序不同
 * @author xm
 *
 */
public class Solution {
	/**
	 * 哈希表
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isAnagram(String s, String t) {

    	//参数检验
    	if(s.length() != t.length()) {
    		return false;
    	}
    	
    	int[] counter = new int[26];
    	for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
    	
    	for (int value : counter) {
			if(value != 0) {
				return false;
			}
		}
    	return true;
    }
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.isAnagram("anagram", "nagaram"));
		System.out.println(obj.isAnagram("anagram", "nagarbm"));

	}

}
