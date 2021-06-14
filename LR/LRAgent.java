package examples.LR;
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;


public class LRAgent extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        // Add the generic behaviour
        addBehaviour(new LRBehavior());
    }


    private class LRBehavior extends Behaviour {
        boolean leave = false;
        LRBehavior() {
        }

        public void action() {
            
            Scanner scanner = new Scanner(System.in);
           

            double[] x = new double[4];
            x[0]= 1;
            for (int i = 0; i < 3; i++) {
                switch( i) {
                    case 0:
                        System.out.println("GMAT:");
                        break;
                    case 1:
                        System.out.println("GPA:");
                        break;
                    case 2:
                        System.out.println("Work experience:");
                        break;
                }
                
                double input = scanner.nextDouble();
                x[i+1] = input;
            }
            LR lr = new LR();
            lr.predict(x);            
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
