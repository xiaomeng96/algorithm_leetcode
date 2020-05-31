package _1021;

public class Solution {
	
	public String removeOuterParentheses(String S) {
		StringBuffer sb=new StringBuffer();
		int idx=0;
		int num=0;
		for (int i = 0; i < S.length(); i++) {
			if('('==S.charAt(i)) {
				num++;
			}else if(')'==S.charAt(i)) {
				num--;
			}
			if(num==1 && '('==S.charAt(i)) {
				//记录每个原语的起始位置
				idx=i;
			}else if(num==0) {
				sb.append(S.substring(idx+1, i));
			}
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		String s1="(()())(())";
		System.out.println(so.removeOuterParentheses(s1));
		String s2="(()())(())(()(()))";
		System.out.println(so.removeOuterParentheses(s2));
		String s3="()()";
		System.out.println(so.removeOuterParentheses(s3));
		
	}

}
