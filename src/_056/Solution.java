package _056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * @author xm
 *
 */
public class Solution {
	/*
	 * 贪心
	 * 排序 
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：o(n)
	 */
    public int[][] merge(int[][] intervals) {
    	//先按照区间的起始位置进行排序
    	Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}    		
    	});
    	
    	
    	int[][] res = new int[intervals.length][2];
    	int idx = -1;
    	for (int[] interval : intervals) {
			//当结果数组为空或者结果数组最后一个区间的右边界 < 当前区间的左边界
    		if(idx == -1 || res[idx][1] < interval[0]) {
    			res[++idx] = interval;
    		}else {
    			res[idx][1] = Math.max(res[idx][1], interval[1]);
    		}
		}
    	return Arrays.copyOf(res, idx+1);
    			
    }
	public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

	}

}
