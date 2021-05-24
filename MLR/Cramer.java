package examples.MLR;

public class Cramer {
    private int N = 3;

    private double[][] getSystemMatrix(double[][] matrix) {
        double[][] result = new double[this.N][this.N];
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    private double[][] getMatrix(double[][] matrix, int idxToSkip) {
        double[][] result = new double[this.N][this.N];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (idxToSkip != j) {
                    result[i][j] = matrix[i][j];
                }
            }
        }
        return result;
    }

    private double[][] getXMatrix(double[][] matrix) {
        double[][] result = new double[this.N][this.N];
        for (int i = 0; i < this.N; i++) {
            for (int j = 1; j < this.N; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < this.N; i++) {
            result[i][0] = matrix[i][this.N];
        }
        return result;
    }

    private double[][] getYMatrix(double[][] matrix) {
        double[][] result = new double[this.N][this.N];
        for (int i = 0; i < this.N; i++) {
            result[i][0] = matrix[i][0];
            result[i][1] = matrix[i][3];
            result[i][2] = matrix[i][2];
        }

        return result;
    }

    private double[][] getZMatrix(double[][] matrix) {
        double[][] result = new double[this.N][this.N];
        for (int i = 0; i < this.N; i++) {
            result[i][0] = matrix[i][0];
            result[i][1] = matrix[i][1];
            result[i][2] = matrix[i][3];
        }

        return result;
    }

    public double[] solveEquation(double[][] matrix) {
        double[][] systemMatrix = this.getSystemMatrix(matrix);
        double[][] xMatrix = this.getXMatrix(matrix);
        double[][] yMatrix = this.getYMatrix(matrix);
        double[][] zMatrix = this.getZMatrix(matrix);

        double systemDeterminant = Matrix.determinant(systemMatrix);
        double xDeterminant = Matrix.determinant(xMatrix);
        double yDeterminant = Matrix.determinant(yMatrix);
        double zDeterminant = Matrix.determinant(zMatrix);

        double[] result = new double[3];

        result[0] = xDeterminant / systemDeterminant;
        result[1] = yDeterminant / systemDeterminant;
        result[2] = zDeterminant / systemDeterminant;
        return result;
    }

    Cramer() {

    }
}
