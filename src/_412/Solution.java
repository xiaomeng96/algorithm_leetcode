package _412;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 412. Fizz Buzz
 * @author xiaomeng
 *
 */
public class Solution {

	/**
	 * 散列法
	 * 1.用散列表建立一个更自由的映射关系
	 * 2.减少了多余的条件判断，如被15整除
	 * @param n
	 * @return
	 */
	public List<String> fizzBuzz(int n) {
		List<String> res=new ArrayList<String>();
		
		//LinkedHashMap可以保证进出的顺序
		Map<Integer, String> map=new LinkedHashMap<Integer, String>(){
			{
				put(3, "Fizz");
				put(5, "Buzz");
			}
		};
		for (int num = 1; num <= n; num++) {
			
			String str="";
			for (Integer key : map.keySet()) {
				if(num%key==0)
					str  += map.get(key);
			}
			
			if(str.equals("")) {//str为空，说明num不能被3或5整除
				str += Integer.toString(num);
			}
			res.add(str);
		}
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so=new Solution();
		List<String> res=so.fizzBuzz(15);
		for (String string : res) {
			System.out.println(string);
		}
	}

}
