package examples.LR;

public class LR {
    private LRHelper lr;
    public void predict(double[] x){
        System.out.println(this.lr.predict(x));
        if (this.lr.predict(x) > 0.5) {
            System.out.println("Admitted");
        }else{
            System.out.println("Not Admitted");
        }
    }
    
    
    LR(){
        Dataset ds = new Dataset();
        LRHelper lr = new LRHelper(ds.getMatrixX(),ds.getMatrixY());
        this.lr = lr;
    }

}
