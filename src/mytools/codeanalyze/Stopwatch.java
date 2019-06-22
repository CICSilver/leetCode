package mytools.codeanalyze;

public class Stopwatch {
    private double start=0;
    public Stopwatch() {
        reset();
    }

    public double elapsedTime() {
        return (System.currentTimeMillis()-start)/1000;
    }

    public void reset(){
        start=System.currentTimeMillis();
    }
}
