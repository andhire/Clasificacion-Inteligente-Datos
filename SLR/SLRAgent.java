package examples.SLR;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;

public class SLRAgent extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        // Add the generic behaviour
        Object[] args = getArguments();
        String valueToPredict = (String) args[0];
        addBehaviour(new SLROneShotBehavior(Float.parseFloat(valueToPredict)));
    }

    private class SLROneShotBehavior extends OneShotBehaviour {
        private float valueToPredict;

        SLROneShotBehavior(float valueToPredict) {
            this.valueToPredict = valueToPredict;
        }

        public void action() {
            System.out.println("One-shot SLR");
            SimpleLinearRegression slr = new SimpleLinearRegression();
            System.out.println(slr.predictValue(this.valueToPredict));
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }

}
