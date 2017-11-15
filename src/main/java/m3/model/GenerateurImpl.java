package m3.model;

import m3.model.observer.Observateur;
import m3.model.proxy.Generateur;
import m3.model.strategy.AlgoDiffusion;

import java.util.ArrayList;


public class GenerateurImpl implements Generateur {

    private int value;
    private ArrayList<AlgoDiffusion> algo;

    public GenerateurImpl() {
        this.algo = new ArrayList<>();
    }

    public void genererValue() throws InterruptedException {
        while (true) {
            this.value++;
            System.out.println("New generated value");
            Thread.sleep(2000);
            for (Observateur o : this.observateurs) {
                System.out.println("Update canal");
                o.update(this);
            }
        }
    }

    @Override
    public int getValue() {
        System.out.println("Get value : " + this.value);
        return this.value;
    }

    @Override
    public void attach(Observateur o) {
        this.observateurs.add(o);
    }

    @Override
    public void detach(Observateur o) {
        this.observateurs.remove(o);
    }

    public void addAlgo(AlgoDiffusion a) {
        this.algo.add(a);
    }

    public void removeAlgo(AlgoDiffusion a) {
        this.algo.remove(a);
    }
}
