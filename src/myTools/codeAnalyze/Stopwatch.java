package myTools.codeAnalyze;

public class Stopwatch {
    private double start=0;
    public Stopwatch() {
        start=System.currentTimeMillis();
    }

    public double elapsedTime() {
        double endTime=System.currentTimeMillis();
        return (endTime-start)/1000;
    }

}
