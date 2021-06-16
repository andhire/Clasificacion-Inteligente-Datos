package examples.KNN;
import java.lang.Math;
class Distance {
    static public double calculateDistance(double x, double y , double a, double b ){
        double squares = Math.pow(x-a, 2) + Math.pow(y-b, 2);
        double sqrt = Math.sqrt(squares);
        return sqrt;
    }
}
