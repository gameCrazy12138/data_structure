package com.soft;

import java.util.Arrays;

public class Recursion1 {
	static int arr[] = { 23, 11, 45, 45, 25, 13 };

	// 求最小值的思路
	// 1 6个数,取第一个数作为最小值
	// 2 取这个数minNum和后面的数比较,取较小值替换之前的变量minNum
	// 3 循环结束的时候,就是我们的最小值
	public int getMinValue(int arr[]) {
		int minNum = arr[0]; // 23
		int i = 1;
		// 循环
		for (; i < arr.length; i++) {
			// 从下标为1的数开始比较，依次比较
			// i = 1 arr[i] = 11 minNum = 11
			// i = 2 arr[i] = 45 minNum = 11
			// i = 3 arr[i] = 45 minNum = 11
			// i = 4 arr[i] = 25 minNum = 11
			// i = 5 arr[i] = 13 minNum = 11
			if (arr[i] < minNum) {
				minNum = arr[i];
			}
		}
		return minNum;
	}

	// 求次小值
	public int getLessMin(int arr[]) {
		int minNum = arr[0]; // 23
		int i = 1;
		// index 保存最小值对应的下标，应该和minNum的下标保持一致
		int index = 0;
		// 循环
		for (; i < arr.length; i++) {

			if (arr[i] < minNum) {
				minNum = arr[i];
				index = i;
			}
		}

		// arr[index] 和 arr[0]交换, arr的下标为i的值和下标为0的值交换
		int temp = arr[index];
		arr[index] = arr[0];
		arr[0] = temp;
		System.out.println(Arrays.toString(arr));
		int lessMin = arr[1];
		for (int j = 2; j < arr.length; j++) {
			if (arr[j] < lessMin) {
				lessMin = arr[j];
			}
		}

		return lessMin;
	}
	//求arr[start] 到 arr[end-1]的第k小值
	public int getKth(int arr[],int start,int end, int k) {
		//运行k轮循环,算法结束
		if(start == k){
			return arr[start-1];
		}
		int minNum = arr[start]; // 23
		int i = start + 1;
		// index 保存最小值对应的下标，应该和minNum的下标保持一致
		int index = start;
		// 循环
		for (; i < end; i++) {

			if (arr[i] < minNum) {
				minNum = arr[i];
				index = i;
			}
		}
		// arr[index] 和 arr[start]交换, arr的下标为i的值和下标为0的值交换
		int temp = arr[index];
		arr[index] = arr[start];
		arr[start] = temp;

		//求arr从start+1 到end-1的数组的第k-(start+1)小值
		return getKth(arr,start+1,end,k);
	}

	// 第二种方法求次小值
	// 设置两个变量分别保存次小值和最小值,
	// 循环比较
	public int getLessMinCp(int arr[]) throws Exception {
		if (arr.length < 2) {
			throw new Exception();
		}
		int lessMin, min;
		if (arr[0] > arr[1]) {
			lessMin = arr[0];
			min = arr[1];
		} else {
			lessMin = arr[1];
			min = arr[0];
		}
		for (int j = 2; j < arr.length; j++) {
			if (arr[j] < min) {
				lessMin = min;
				min = arr[j];
			} else if (arr[j] >= min && arr[j] <= lessMin) {
				lessMin = arr[j];
			}
		}
		return lessMin;
	}

	public static void main(String args[]) throws Exception {
		Recursion1 recursion = new Recursion1();
		System.out.println(recursion.getKth(arr, 0, arr.length, 5));
//		System.out.println(recursion.getLessMinCp(arr));
	}

}
