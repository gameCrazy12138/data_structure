package com.soft;

import java.util.Arrays;
import java.util.Scanner;

public class FiveStoneChess {
    private static final int SIZE = 19;

    private int[][] board;//存棋子状态，0代表空值，1代表黑棋，2代表白棋
    public FiveStoneChess(){
        board = new int[SIZE][SIZE];
    }

    //落子算法,随机生成落点，返回落点落在棋盘格的行和列
    public Point getNextMove(){

        double x = Math.random() * 18;
        double y = Math.random() * 18;
        int int_x = (int)x;
        int int_y = (int)y;
        int loc_x = x - int_x > 0.5 ? 1:0;
        int loc_y = y - int_y > 0.5 ? 1:0;
        return new Point(int_x+loc_x,int_y+loc_y);
    }

    //游戏主场景,用户选择落子，落子完成后更新棋盘
    //标记flag ==false 1 黑子，flag ==true 2 白子
    public void play(){
        boolean flag = false;
        while(true){
            //接收用户输入，1 黑子,2 白子
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入整数，1代表黑棋，2代表白棋:");
            if(flag){
                System.out.println("请落白子:");
            }else{
                System.out.println("请落黑子:");
            }
            int cmd = scanner.nextInt();

            if ((cmd ==1&&!flag) || (cmd == 2&&flag)){
                //落子
                Point point = getNextMove();
                int loc_x = (int)point.x;
                int loc_y = (int)point.y;
                System.out.println(loc_x+" "+loc_y);
                //更新棋盘
                if(board[loc_x][loc_y] == 0){
                    board[loc_x][loc_y] = cmd;
                    flag = !flag;
                }

            }else{
                System.out.println("输入不合法");
            }
        }






//        boolean flag = false;
//        //接收用户输入
//        while(true){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("请输入整数,1代表黑棋，2代表白棋");
//            if(flag){
//                System.out.println("请落白子");
//            }else{
//                System.out.println("请落黑子");
//            }
//            int cmd = scanner.nextInt();
//
////        if (cmd ==1 || cmd ==2){
////            //根据用户输入指令落子
////            Point move = getNextMove();
////            int move_x = (int)move.x;
////            int move_y = (int)move.y;
////
////            //更新棋盘
////            board[move_x][move_x] = cmd;
////        }else{
////            System.out.println("输入不合法");
////            return;
////        }
//
//            //只能落黑子或者落白子
//            if((!flag&&cmd==1)||(flag&&cmd==2)){
//
//                //根据用户输入指令落子
//                Point move = getNextMove();
//                int move_x = (int)move.x;
//                int move_y = (int)move.y;
//                System.out.println(move_x+" "+move_y);
//
//                //更新棋盘
//                if(board[move_x][move_y] == 0){
//                    board[move_x][move_y] = cmd;
//                    flag = !flag;
//                }
//
//            }else{
//                System.out.println("输入不合法");
//                return;
//            }
//
//
//        }

    }

    public static void main(String[] args) {
//        FiveStoneChess fiveStoneChess = new FiveStoneChess();
//        fiveStoneChess.play();
        System.out.println(Arrays.toString("I  am Jim".split(" ")));
    }
}
