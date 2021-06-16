package examples.KNN;

class Rank implements Comparable<Rank>{
    public int idx;
    public double distance;
    Rank(int idx, double distance){
        this.idx  = idx;
        this.distance = distance;
    }
    
    public int compareTo(Rank o) {
       if(this.distance > o.distance){
           return 1;
       }
       return -1;
    }
    
    
}
