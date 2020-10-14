package com.gupt;

import java.util.Arrays;

public class Recursion {
	static int arr[] = {23,11,45,45,25,13};
	//求最小值的思路
	// 1 6个数,取第一个数作为最小值
	// 2 取这个数minNum和后面的数比较,取较小值替换之前的变量minNum
	// 3 循环结束的时候,就是我们的最小值
	public int getMinValue(int arr[]){
		int minNum = arr[0]; //23
		int i=1;
		//循环
		for(;i<arr.length;i++){
			//从下标为1的数开始比较，依次比较
			// i = 1  arr[i] = 11 minNum = 11
			// i = 2  arr[i] = 45 minNum = 11
			// i = 3  arr[i] = 45 minNum = 11
			// i = 4  arr[i] = 25 minNum = 11
			// i = 5  arr[i] = 13 minNum = 11
			if(arr[i] < minNum){
				minNum = arr[i];  
			}
		}
		return minNum;
	}
	
	
	//求次小值
	public int getLessMin(int arr[]){
		int minNum = arr[0]; //23
		int i=1;
		//index 保存最小值对应的下标，应该和minNum的下标保持一致
		int index = 0;
		//循环
		for(;i<arr.length;i++){
			
			if(arr[i] < minNum){
				minNum = arr[i];  
				index = i;
			}
		}
		
		//arr[index] 和 arr[0]交换, arr的下标为i的值和下标为0的值交换
		int temp = arr[index];
		arr[index] = arr[0];
		arr[0] = temp;
		System.out.println(Arrays.toString(arr));
		int lessMin = arr[1];
		for(int j=2;j<arr.length;j++){
			if(arr[j] < lessMin){
				lessMin = arr[j];  
			}
		}
		
		return lessMin;
	}
	
	public static void main(String args[]){
		Recursion recursion = new Recursion();
		System.out.println(recursion.getLessMin(arr));
	}
	
	

}
