package com.soft;

import java.util.Random;

public class Vertification {

    public static final String character_set = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int num;
    //num 生成的字符长度
    public  Vertification(int num){
        this.num = num;
    }

    public String getCode(){
//        1.定义字符集字母和数字
//        2.每次从字符集中取一位字符
//        3.拼接
//        4.排除重复的字符
        //保存字符串的值
        String result="";
        Random random = new Random();
        int len = character_set.length();
        //循环次数不确定
        for(;result.length()<num;){
            //index:[0,len)
            int index = random.nextInt(len);
            char ch = character_set.charAt(index);

            //判断字符不在字符串里
            if(result.indexOf(ch)<0){
                //"0" ""+'0'
                result = result+ch;
                System.out.println(result);
            }

//            if(result.indexOf(ch)>=0){
//                continue;
//            }
//            result = result+ch;

        }
        return result;
    }

    public static void main(String[] args) {
        
        Vertification vf = new Vertification(4);
        System.out.println(vf.getCode());
    }
}
