package com.test;


import java.util.Scanner;

public class FiveStoneChess {

    private static final int SIZE = 19;
    private int board[][];
    public FiveStoneChess(){
        board = new int[SIZE][SIZE];
    }

    //落子算法
    public  Point getNextMove(){
        double x = Math.random()*18;
        double y = Math.random()*18;
        int int_x = (int)x;
        int int_y = (int)y;
        int x_offset = x - int_x > 0.5 ? 1:0;
        int y_offset = y - int_y > 0.5 ? 1:0;
        return new Point(int_x+x_offset,int_y+y_offset);

    }

    public void play(){
        boolean flag = false;
        while(true){
            Scanner scanner = new Scanner(System.in);
            if (!flag){
                System.out.print("输入1表示落黑子，输入2表示落白子,请落黑子:\n");
            }else{
                System.out.print("输入1表示落黑子，输入2表示落白子,请落白子:\n");
            }

            int cmd = scanner.nextInt();

            if((!flag && cmd ==1)||(flag && cmd==2)){
                Point move = getNextMove();
                int move_x = (int)move.x;
                int move_y = (int)move.y;
                if (board[move_x][move_y] == 0){
                    board[move_x][move_y] = cmd;
                    flag = !flag;
                }
                System.out.println(move_x+" "+move_y);
            }else{
                System.out.println("输入不合法");
                continue;
            }


        }


    }



    public static void main(String[] args) {
        FiveStoneChess fiveStoneChess = new FiveStoneChess();
        fiveStoneChess.play();
    }
}

//x,y表示一个坐标
class Point{
    double x;
    double y;
    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }

}
