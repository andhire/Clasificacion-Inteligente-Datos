package examples.MLR;

class Dataset {
    private double[][] matrixX;
    private double[][] matrixY;

    public double[][] getMatrixX() {
        return this.matrixX;
    }

    public void setMatrixX(double[][] matrix) {
        this.matrixX = matrix;
    }

    public double[][] getMatrixY() {
        return this.matrixY;
    }

    public void setMatrixY(double[][] matrix) {
        this.matrixY = matrix;
    }

    public Dataset(double[][] matrixX, double[][] matrixY) {
        this.matrixX = matrixX;
        this.matrixY = matrixY;
    }

    public Dataset() {
        this.matrixX = new double[][] { { 1, 41.9, 29.1 }, { 1, 43.4, 29.3 }, { 1, 43.9, 29.5 }, { 1, 44.5, 29.7 },
                { 1, 47.3, 29.9 }, { 1, 47.5, 30.3 }, { 1, 47.9, 30.5 }, { 1, 50.2, 30.7 }, { 1, 52.8, 30.8 },
                { 1, 53.2, 30.9 }, { 1, 56.7, 31.5 }, { 1, 57, 31.7 }, { 1, 63.5, 31.9 }, { 1, 65.3, 32 },
                { 1, 71.1, 32.1 }, { 1, 77, 32.5 }, { 1, 77.8, 32.9 } };
        this.matrixY = new double[][] { { 251.3 }, { 251.3 }, { 248.3 }, { 267.5 }, { 273 }, { 276.5 }, { 270.3 },
                { 274.9 }, { 285 }, { 290 }, { 297 }, { 302.5 }, { 304.5 }, { 309.3 }, { 321.7 }, { 330.7 }, { 349 } };
    }
}