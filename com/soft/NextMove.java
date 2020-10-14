package com.soft;

import java.util.HashMap;
import java.util.Map;


//x,y表示一个坐标
class Point{
    double x;
    double y;
    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }

}
public class NextMove {

    public double getDistance(Point point_a,Point point_b){
        return Math.sqrt((point_a.x-point_b.x)*(point_a.x-point_b.x)+(point_a.y-point_b.y)*(point_a.y-point_b.y));

    }
    public Point move(){

        Point point_random = new Point(Math.random(),Math.random());

        Point point_0_0 = new Point(0,0);
        Point point_0_1 = new Point(0,1);
        Point point_1_1 = new Point(1,1);
        Point point_1_0 = new Point(1,0);

        double distance_00_random = getDistance(point_0_0,point_random);
        double distance_01_random = getDistance(point_0_1,point_random);
        double distance_11_random = getDistance(point_1_1,point_random);
        double distance_10_random = getDistance(point_1_0,point_random);

        Map<Point,Double> point_distance_map = new HashMap();

        point_distance_map.put(point_0_0,distance_00_random);
        point_distance_map.put(point_0_1,distance_01_random);
        point_distance_map.put(point_1_1,distance_11_random);
        point_distance_map.put(point_1_0,distance_10_random);

        double min_distance = distance_00_random;
        Point point = new Point(0,0);
        for(Map.Entry<Point,Double> entry:point_distance_map.entrySet()){
            if (entry.getValue() < min_distance){
                min_distance = entry.getValue();
                point = entry.getKey();
            }
        }
        return point;

    }

    public static void main(String[] args) {
        int x = Math.random()>0.5?1:0;
        int y = Math.random()>0.5?1:0;

        NextMove nextMove = new NextMove();
        Point move = nextMove.move();
        System.out.printf("%d,%d",(int)move.x,(int)move.y);
    }

}

