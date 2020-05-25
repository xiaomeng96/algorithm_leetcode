package _350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * @author xiaomeng
 *
 */
public class Solution1 {
	
	/**
	 * 方法一：哈希映射
	 * 时间复杂度O(m+n);空间复杂度O(min(m,n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		//nums1的长度大于nums2，就交换两个数组
		if(nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}
		//创建 一个哈希映射表，将nums1中的值映射到哈希表中
		Map<Integer, Integer> map=new HashMap<>();
		for (int num : nums1) {
			//当map中有这个key时，就使用这个key值；否则就使用默认值
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		int k=0;
		for (int num : nums2) {
			//map中包含num关键字，并且对应值大于0
			if(map.containsKey(num) && map.get(num)>0) {
				nums1[k++]=num;
				map.put(num, map.get(num)-1);
			}
		}	
		return Arrays.copyOfRange(nums1, 0, k);

    }
	/**
	 * 方法二：排序+双指针
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i=0, j=0, k=0;
		while(i<nums1.length && j<nums2.length) {
			if(nums1[i] < nums2[j]) {
				i++;
			}else if(nums1[i] > nums2[j]) {
				j++;
			}else {
				nums1[k++] = nums1[i++];
				j++;
			}
		}
		return Arrays.copyOfRange(nums1, 0, k);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums1= {1,2,2,1};
//		int[] nums2= {2,2};
		int[] nums1= {4,9,5};
		int[] nums2= {9,4,9,8,4};
		int[] res=intersect2(nums1, nums2);
		for (int i : res) {
			System.out.print(i + " ");
		}
		
	}

}
