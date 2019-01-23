import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import myTools.codeAnalyze.Stopwatch;
import myTools.codeAnalyze.logAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;


public class practiceE1 {
    public static int rank(int key,int[] a) {
        int lo=0;
        int hi=a.length-1;
        while(lo<=hi) {
            int mid=(hi-lo)/2+lo;
            if(key<a[mid]) { hi=mid-1;}
            else if(key>a[mid]) { lo=mid+1;}
            else { return a[mid];}
        }
        return -1;
    }
    public static void twoSearch(int[] littleArray,int[] largeArray) {
        Arrays.sort(largeArray);
        for(int i=0;i<littleArray.length;i++) {
            if(practiceE1.rank(littleArray[i],largeArray)>0) {
                System.out.println(littleArray[i]);
            }
        }
    }
    public static void tstSearch(int[] littleArray,int[] largeArray) {
        for (int i2 : littleArray) {
            for (int i1 : largeArray) {
                if (i2 == i1) {
                    System.out.println(i2);
                }
            }
        }
    }
    public static void randomInt(String filename,int n) {
        Out out=new Out(filename);
        for(int i=0;i<n;i++) {
            out.println(StdRandom.uniform(n));
        }
        out.close();
    }
    public static void main(String[] args) {
        String filename="D://test.txt";
        String largeFilename="D://test2.txt";
/*        int n1=100000;
        int n2=1000000;
        practiceE1.randomInt(filename,n1);
        practiceE1.randomInt(largeFilename,n2);*/
        In in=new In(filename);
        In inLarge=new In(largeFilename);
        int[] littleArray=in.readAllInts();
        int[] largeArray=inLarge.readAllInts();
        Stopwatch stopwatch=new Stopwatch();
        practiceE1.twoSearch(littleArray,largeArray);
        double time=stopwatch.elapsedTime();
        edu.princeton.cs.algs4.Stopwatch stopwatch1=new edu.princeton.cs.algs4.Stopwatch();
        practiceE1.tstSearch(littleArray,largeArray);
        double time2=stopwatch.elapsedTime();
        System.out.println(time);
        System.out.println(time2);
    }

}
