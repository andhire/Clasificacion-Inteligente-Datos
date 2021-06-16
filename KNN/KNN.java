package examples.KNN;


public class KNN {
    private KNNHelper knnHelper;
    private int k = 1;
    KNN(double x, double y) {
        Dataset dataset = new Dataset();
        this.knnHelper = new KNNHelper(x, y, dataset, this.k);
    }

    String findNearestNeighbor(){
        this.knnHelper.calculateDistances();
        this.knnHelper.rank();
        return this.knnHelper.findNearestNeighbor();
    }

    public static void main(String[] args) {
        KNN knn = new KNN(6.2, 2.4);
        System.out.println(knn.findNearestNeighbor());
    }
}
