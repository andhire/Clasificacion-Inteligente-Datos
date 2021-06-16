package examples.KNN;
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;


public class KNNAgent extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        // Add the generic behaviour
        addBehaviour(new KNNBehavior());
    }


    private class KNNBehavior extends Behaviour {
        boolean leave = false;
        KNNBehavior() {
        }

        public void action() {
            
            Scanner scanner = new Scanner(System.in);
           


            System.out.println("Sepal length: ");
            double x = scanner.nextDouble();
            System.out.println("Sepal width: ");
            double y = scanner.nextDouble();
            KNN knn = new KNN(x,y);            
            System.out.println(knn.findNearestNeighbor());
            System.out.println("\n1-Salir");
            int input = scanner.nextInt();
            if(input == 1){
                leave = true;
                scanner.close();
                return;
            }
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }

        public boolean done() {
            return leave;
        }
    }

}
