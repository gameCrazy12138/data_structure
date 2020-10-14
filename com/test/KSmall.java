package com.test;

import java.util.Arrays;

public class KSmall {

    public int findKth(int arr[],int left,int right,int k){
        if (left == k){
            return arr[left-1];
        }

        int min = arr[left];
        int index = left;
        for (int i = left+1; i <= right; i++){
            if (arr[i] <= min){
                min = arr[i];
                index = i;
            }
        }
        arr[index] = arr[left];
        arr[left] = min;
        return findKth(arr,left+1,right,k);
    }

    public static void main(String[] args) {
        int arr[] = {1,9,3,2,5};
//        Arrays.fill(arr,(int)Math.random()*10+1);
        System.out.println(Arrays.toString(arr));
        KSmall ksmall = new KSmall();
        int num  = ksmall.findKth(arr,0,arr.length-1,4);
        System.out.println(Arrays.toString(arr));
        System.out.println(num);


    }
}
