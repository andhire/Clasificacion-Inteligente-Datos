package examples.SLR;

public class SimpleLinearRegression {

    private double m;
    private double b;

    public void addDataSet(double[] x, double[] y) {
        int N = x.length;
        double sumX = 0.0;
        double sumY = 0.0;
        double sumXY = 0.0;
        double sumXSquare = 0.0;

        for (int i = 0; i < N; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += (x[i] * y[i]);
            sumXSquare += (x[i] * x[i]);
        }

        // Get slope
        m = ((N * sumXY) - (sumX * sumY)) / ((N * sumXSquare) - (sumX * sumX));
        b = (sumY / N) - (m * (sumX / N));
    }

    public double predictValue(double valueToPredict) {
        String formula = "y = " + b + " + " + m + "*" + valueToPredict;
        System.out.println(formula);
        return b + (m * valueToPredict);
    }

    public SimpleLinearRegression() {
        double[] x = new double[] { 23, 26, 30, 34, 43, 48, 52, 57, 58 };
        double[] y = new double[] { 651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518 };
        addDataSet(x, y);
    }

}
