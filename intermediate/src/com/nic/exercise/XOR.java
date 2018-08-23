package com.nic.exercise;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 *
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 *
 *
 * Created by james on 2018/8/23 0023.
 */
public class XOR {
	/**
	 * 大量数据会导致时间太久
	 * @param nums
	 * @return
	 */
	public int findMaximumXOR(int[] nums) {
		if (nums.length == 1) return 0;
		if (nums.length == 2) return nums[0] * nums[1];
		TreeSet<Integer> integers = new TreeSet<>();
		for (int i = 0; i < nums.length; i++){
			for (int j = i+1; j < nums.length; j++){
				integers.add(nums[i] ^ nums[j]);
			}
		}
		Iterator<Integer> iterator = integers.iterator();
		while (iterator.hasNext()){
			Integer next = iterator.next();
			System.out.println("next="+next);
		}
		return integers.last();
	}

	public int findMaximumXOR2(int[] nums){
		int max = 0, mask = 0;
		for(int i = 31; i >= 0; i--){
			mask = mask | (1 << i);
			System.out.println("mask=" + mask);
			Set<Integer> set = new HashSet<>();
			for(int num : nums){
				set.add(num & mask);
			}
			int tmp = max | (1 << i);
			System.out.println("tmp=" + tmp);
			for(int prefix : set){
				System.out.println("prefix=" + prefix);
				if(set.contains(tmp ^ prefix)) {
					max = tmp;
					break;
				}
			}
		}
		return max;
	}


	@Test
	public void test(){
//		int[] a = {3, 10, 5, 25, 2, 8};
		int[] a = {4,6,7};
//		System.out.println(findMaximumXOR(a));
//		System.out.println(0 | 1 << 10);
//		System.out.println(2^4);
		System.out.println(-2147483648 | -1073741824);
//		System.out.println(findMaximumXOR2(a));
	}
}
