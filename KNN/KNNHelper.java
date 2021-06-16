package examples.KNN;
import java.util.Arrays;
class KNNHelper {
    private double[] distances;
    private Dataset dataset; 
    private double x;
    private double y;
    private Rank[] rank;

    private int k;
    KNNHelper(double x, double y, Dataset dataset, int k){
        this.dataset = dataset;
        
        this.x = x;
        this.y = y;
        this.k = k;
        
        this.distances = new double[dataset.getMatrixX().length];
        this.rank = new Rank[this.distances.length];

        
    }

    public void calculateDistances(){
        for (int i = 0; i < this.distances.length; i++) {
            this.distances[i] = Distance.calculateDistance(x, y, dataset.getMatrixX()[i][0], dataset.getMatrixX()[i][1]);
            this.rank[i] = new Rank(i,this.distances[i]);

        }
    }

    public void rank(){
        Arrays.sort(this.rank);
    }

    public String findNearestNeighbor(){
        
        int setosa = 0;
        int virginica = 0;
        int versicolor = 0;

        for (int i = 0; i < k; i++) {
            String neighbor = dataset.getMatrixY()[rank[i].idx][0];
            switch (neighbor) {
                case "Setosa":
                    setosa++;
                    break;
                case "Virginica":
                    virginica++;
                    break;
                case "Versicolor":
                    versicolor++;
                    break;
            }
        }

        int max = Math.max(setosa, virginica);
        max = Math.max(max,versicolor);

        if (setosa == max){
            return "Setosa";
        }

        if (virginica == max){
            return "Virginica";
        }

        return "Versicolor";
        
    }


}
