package examples.LR;

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
        this.matrixX = new double[][] { {1, 780,4,3 },{1,750,3.9,4},{1,690,3.3,3},{1,710,3.7,5},{1,680,3.9,4},{1,730,3.7,6},{1,690,2.3,1},{1,720,3.3,4},{1,740,3.3,5}  };
        this.matrixY = new double[][] { {1 },{1},{0},{1},{0},{1},{0},{1},{1} };
    }
}