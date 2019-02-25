import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.*;


public class Draw{
    private void drawRectangle(int i,int len,double num) {
        double y=num/2.0;
        double width=0.5/len;
        double x=1.0*i/len+width;
        //(x,y)为矩形条中心点坐标，width为矩形宽度的一般
        StdDraw.filledRectangle(x,y,width-0.003,y);
    }
    public static void main(String[] args){
        int len=50;
        int i=0;
        Draw draw=new Draw();
        List<Double> list=new ArrayList<>();
        for(;i<len;i++) {
            list.add(StdRandom.uniform());
        }
        for(i=0;i<len;i++) {
            draw.drawRectangle(i,len,list.get(i));
            StdDraw.pause(20);
        }
        StdDraw.pause(1000);
        list.sort(Double::compareTo);
        StdDraw.clear();
        for(i=0;i<len;i++) {
            draw.drawRectangle(i,len,list.get(i));
            StdDraw.pause(20);
        }
    }
}

