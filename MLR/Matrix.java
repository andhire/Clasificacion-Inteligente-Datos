package examples.MLR;

public class Matrix {
    public static double[][] transposeMatrix(double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        double[][] result = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrix(double[][] A, double[][] B) {
        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;
        if (aColumns != bRows) {
            throw new IllegalStateException("Dimensiones no validas");
        }
        double[][] result = new double[aRows][bColumns];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                for (int k = 0; k < aColumns; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static double determinant(double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (n != m) {
            throw new IllegalStateException("Dimensiones no validas");
        }
        if (n == 2) {
            return ((matrix[0][0] * matrix[1][1]) - (matrix[1][0] * matrix[0][1]));
        }
        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i] * determinant(minor(matrix, 0, i));
        return det;
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i != row && j < matrix[i].length; j++) {
                if (j != column) {
                    if (i < row) {
                        if (j < column) {
                            minor[i][j] = matrix[i][j];
                        } else {
                            minor[i][j - 1] = matrix[i][j];
                        }

                    } else {
                        if (j < column) {
                            minor[i - 1][j] = matrix[i][j];
                        } else {
                            minor[i - 1][j - 1] = matrix[i][j];
                        }
                    }
                }
            }
        }

        return minor;
    }

    public static double[][] inverse(double[][] matrix) {
        double[][] inverseMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverseMatrix[i][j] = (double) (Math.pow(-1, i + j) * determinant(minor(matrix, i, j)));

        // adjugate and determinant
        double det = 1 / determinant(matrix);
        for (int i = 0; i < inverseMatrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverseMatrix[i][j];
                inverseMatrix[i][j] = inverseMatrix[j][i] * det;
                inverseMatrix[j][i] = temp * det;
            }
        }

        return inverseMatrix;
    }


}
