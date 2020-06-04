package _005;

/**
 * 面试题05. 替换空格
 * @author xiaomeng
 *
 */
public class Solution {
	
	/**
	 * 方法1：使用字符数组
	 * 时间复杂度O(n)； 空间复杂度O(n)
	 * @param s
	 * @return
	 */
    public String replaceSpace(String s) {
    	if(s==null || s.length() == 0)
    		return s;
    	
    	int count=0;//统计' '的个数
    	for (Character c : s.toCharArray()) {
			if(c==' ') {
				count++;
			}
		}
    	int n=s.length();
    	char[] res=new char[n + 2*count];
    	int size=0;
    	for (int i = 0; i < n; i++) {
			char c=s.charAt(i);
			if(c == ' ') {
				res[size++] = '%';
				res[size++] = '2';
				res[size++] = '0';
			}else {
				res[size++] = c;
			}
		}
    	String newStr = new String(res, 0, size);
    	return newStr;

    }
    
    //方法2：使用StringBuilder
    public String replaceSpace2(String s) {
    	if(s==null || s.length() == 0)
    		return s;
    	
    	StringBuffer res = new StringBuffer();
    	for (Character c : s.toCharArray()) {
			if(c==' ') {
				res.append("%20");
			}else {
				res.append(c);
			}
		}
    	return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		String s = "  ";
		System.out.println(so.replaceSpace(s));
		System.out.println(so.replaceSpace2(s));
	}

}
