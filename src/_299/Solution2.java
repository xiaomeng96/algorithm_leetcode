package _299;

public class Solution2 {
	
	public static String getHint(String secret, String guess) {
		int a=0;
		int b=0;
		int[] ds=new int[10];
		int[] dg=new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int s=secret.charAt(i)-'0';
			int g=guess.charAt(i)-'0';
			if(s==g) {
				a++;//公牛数
			}else {
				ds[s] += 1;
				dg[g] += 1;
			}
		}
		
		for (int j = 0; j < dg.length; j++) {
			b += Math.min(ds[j], dg[j]);//奶牛数
		}
		
		return a+"A"+b+"B";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("2123", "0111"));
	}

}
