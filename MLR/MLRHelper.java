package examples.MLR;

public class MLRHelper {
    private double sumY = 0;
    private double sumX0 = 0;
    private double sumX0Y = 0;
    private double sumX0Square = 0;
    private double sumX1 = 0;
    private double sumX1Y = 0;
    private double sumX0X1 = 0;
    private double sumX1Square = 0;
    private int length;

    public void getSums(double[][] matrixX, double[][] matrixY) {
        this.length = matrixX.length;
        for (int i = 0; i < matrixY.length; i++) {
            double y = matrixY[i][0];
            double x0 = matrixX[i][1];
            double x1 = matrixX[i][2];

            this.sumY += y;
            this.sumX0 += x0;
            this.sumX1 += x1;
            this.sumX0Y += x0 * y;
            this.sumX1Y += x1 * y;
            this.sumX0X1 += x0 * x1;
            this.sumX0Square += x0 * x0;
            this.sumX1Square += x1 * x1;

        }
    }

    public double[][] createEquations() {
        double[][] result = new double[3][4];
        // Ecuation X0Ys
        result[0][0] = this.sumX0Square;
        result[0][1] = this.sumX0X1;
        result[0][2] = this.sumX0;
        result[0][3] = this.sumX0Y;

        // Equation x1Y1s
        result[1][0] = this.sumX0X1;
        result[1][1] = this.sumX1Square;
        result[1][2] = this.sumX1;
        result[1][3] = this.sumX1Y;

        // Equation Ys
        result[2][0] = this.sumX0;
        result[2][1] = this.sumX1;
        result[2][2] = this.length;
        result[2][3] = this.sumY;
        return result;
    }

    MLRHelper() {
    }

    MLRHelper(double[][] matrixX, double[][] matrixY) {
        this.getSums(matrixX, matrixY);
    }
}
