import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;


public class Draw{
    public static void main(String[] args){
        int len=50;
        StdDraw.setCanvasSize(1024 ,1024);
        double[] array=new double[len];
        for(int i=0;i<len;i++) {
            array[i]= StdRandom.uniform();
        }
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        for(int i=0;i<len;i++) {
            double y= array[i]/2.0;
            double width=0.5 / len;
            double x= 1.0 * i / len+width;
            double height=array[i]/2.0;
            StdDraw.filledRectangle(x,y,width-0.003,height);

        }
    }
}

