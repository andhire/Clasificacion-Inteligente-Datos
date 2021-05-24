package examples.MLR;
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;


public class MLRAgent extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        // Add the generic behaviour
        addBehaviour(new MLRBehavior());
    }


    private class MLRBehavior extends Behaviour {
        boolean leave = false;
        MLRBehavior() {
        }

        public void action() {
            
            Scanner scanner = new Scanner(System.in);
           


            System.out.println("X: ");
            double x = scanner.nextDouble();
            System.out.println("Z: ");
            double z = scanner.nextDouble();
            MLR mlr = new MLR(x,z);            
            
            System.out.println("1-Salir");
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
