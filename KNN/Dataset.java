package examples.KNN;

class Dataset {
    private double[][] matrixX;
    private String[][] matrixY;

    public double[][] getMatrixX() {
        return this.matrixX;
    }

    public void setMatrixX(double[][] matrix) {
        this.matrixX = matrix;
    }

    public String[][] getMatrixY() {
        return this.matrixY;
    }

    public void setMatrixY(String[][] matrix) {
        this.matrixY = matrix;
    }

    public Dataset(double[][] matrixX, String[][] matrixY) {
        this.matrixX = matrixX;
        this.matrixY = matrixY;
    }

    public Dataset() {
        this.matrixX = new double[][] { {5.3,3.7},{5.1,3.8},{7.2,3},{5.4,3.4},{5.1,3.3},{5.4,3.9},{7.4,2.8},{6.1,2.8},{7.3,2.9},{6,2.7},{5.8,2.8},{6.3,2.3},{5.1,2.5},{6.3,2.5},{5.5,2.4} };
        this.matrixY = new String[][] { {"Setosa"},{"Setosa"},{"Virginica"},{"Setosa"},{"Setosa"},{"Setosa"},{"Virginica"},{"Versicolor"},{"Virginica"},{"Versicolor"},{"Virginica"},{"Versicolor"},{"Versicolor"},{"Versicolor"},{"Versicolor"}};
    }
}