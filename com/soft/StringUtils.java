package com.soft;

import java.util.Arrays;
import java.util.Stack;

public class StringUtils {

    public String reverse() {

        String sentence = "Complex is better than complicated";

        String[] sentence_list = sentence.split(" ");

        String result = "";

        for (int i = sentence_list.length-1; i >= 0; i--) {



//            if (i == 0) {
//                result = result + sentence_list[i];
//            } else {
//                result = result + sentence_list[i] + " ";
//            }
            result = result + sentence_list[i];
            if (i>0){
                result = result + " ";
            }

        }
        return result;

    }


    public String exchangeReverse(){
        String sentence = "Complex is better than complicated";

        String[] sentence_list = sentence.split(" ");

        System.out.println(Arrays.toString(sentence_list));

        String result = "";

        int len = sentence_list.length;

        for(int i = 0;i < len/2;i++){
            String temp = sentence_list[i];

            sentence_list[i] = sentence_list[len-1-i];

            sentence_list[len-1-i] = temp;

            System.out.println("执行交换");
        }
        System.out.println(Arrays.toString(sentence_list));
        for (int k = 0;k < len; k++){
            if (k == len-1){
                result += sentence_list[k];
            }else{
                result += sentence_list[k]+" ";
            }
        }
//        System.out.println(Arrays.toString(sentence_list));
        return result;
    }

    public String exchange() {
        //要将句子逆序输出还能做到单词的原本顺序不改变，只有用空格分割数组
        //              1     2   3      4     5
        String str = "Complex is better than complicated";

        //将句子以空格分割为一个数组

        String[] arr = str.split(" ");

        for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {

            String temp = arr[i];

            arr[i] = arr[j];

            arr[j] = temp;

            System.out.println("执行交换");

        }

        //将数组形式显示为字符串形式

        //不能给null，要给一个空串

        String result = "";

        for (int i = 0; i < arr.length; i++) {

            result += arr[i] + " ";

        }

//        System.out.println(result);
        return result;

    }

    public String recReverse(String str){
        if (str.length() ==  1){
            return str;
        }else{
            return str.substring(str.length()-1)+recReverse(str.substring(0,str.length()-1));
        }
    }


    public static void main(String[] args) {
        StringUtils stringUtils = new StringUtils();
//        System.out.println(stringUtils.reverse());
//        System.out.println(stringUtils.exchange());
        System.out.println(stringUtils.exchangeReverse());
        System.out.println(stringUtils.recReverse("abcde"));

    }
}

//重用性
//包
//wzj.jar