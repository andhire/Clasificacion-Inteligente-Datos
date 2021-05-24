package examples.MLR;

public class MLR {
    private void solveCramer(Dataset ds, double x,double z){
        Cramer cramer = new Cramer();
        MLRHelper myHelper = new MLRHelper();
        myHelper.getSums(ds.getMatrixX(), ds.getMatrixY());
        double[][] equations = myHelper.createEquations();
        double[] solution = cramer.solveEquation(equations);
        predictValueCramer(solution,x,z);
    }

    private void predictValueCramer(double [] equations,double x, double z){
        System.out.println("Cramer");
        String equation = "y = " + equations[0] + "X +" + equations[1] +"X +" + equations[2]; 
        System.out.println(equation);
        double valueToPredict = equations[2] + (equations[0]*x + equations[1]*z);
        System.out.println(valueToPredict);
    }

    private void solveAlgebra(Dataset ds, double x, double z){
        double[][] multiplication = Matrix.multiplyMatrix(Matrix.transposeMatrix(ds.getMatrixX()), ds.getMatrixX());
        double[][] inverse = Matrix.inverse(multiplication);
        multiplication = Matrix.multiplyMatrix(inverse, Matrix.transposeMatrix(ds.getMatrixX()));
        multiplication = Matrix.multiplyMatrix(multiplication, ds.getMatrixY());
        predictValueAlgebra(multiplication,x,z);

    }
    private void predictValueAlgebra(double [][] equations,double x, double z){
        System.out.println("Algebra");
        String equation = "y = " + equations[1][0] + "X +" + equations[2][0] +"Z +" + equations[0][0]; 
        System.out.println(equation);
        double valueToPredict = equations[0][0] + (equations[1][0]*x + equations[2][0]*z);
        System.out.println(valueToPredict);
    }
    
    MLR(double x, double z){
        Dataset ds = new Dataset();
        //Cramer
        solveCramer(ds, x, z);
        //Algebra
        solveAlgebra(ds, x, z);
    }
}
