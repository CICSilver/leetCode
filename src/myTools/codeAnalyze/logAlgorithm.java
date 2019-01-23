package myTools.codeAnalyze;

public class logAlgorithm {
    static public double log(double value,double base) {
        return Math.log(value)/Math.log(base);
    }
    public static void main(String[] args) {
        System.out.println(log(6,2));
    }
}
