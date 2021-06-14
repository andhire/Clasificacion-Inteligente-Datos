package examples.LR;
import java.lang.Math;


public class LRHelper {
    private double[] w = {0,0,0,0};
    private double learningRate = 0.001;
    private double [][] matrixX;
    private double [][] matrixY;
    private int iterations = 1000000;


    private void train(){

        for (int m = 0; m < iterations; m++) {
            for (int rows = 0; rows < matrixX.length; rows++) {
                double[] x = matrixX[rows] ; 
                double predicted = classify(x) ;
                double y = matrixY[rows][0];
                for (int i = 0; i < w.length; i++) {
                    w[i] += -learningRate * ((predicted-y)*x[i]);
                }
            }        
        }
        for (double we: w) {
            System.out.println(we);
        }
        
    }
    private double sigmoid(double sum){
        return 1/(1+Math.exp(-sum));
    }
    private double classify(double[] x){
        double sum = w[0];
        for (int i = 1; i < w.length; i++) {
            sum += w[i]* x[i];
        }
        return sigmoid(sum);
    }
    LRHelper() {
    }
    public double predict(double [] x){
        return classify(x);
    }
    LRHelper(double[][] matrixX, double[][] matrixY) {
        this.matrixX = matrixX;
        this.matrixY = matrixY;
        this.train();
    }

}
