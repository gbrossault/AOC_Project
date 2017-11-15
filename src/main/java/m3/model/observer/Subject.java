package m3.model.observer;

import java.util.ArrayList;

public interface Subject {

    ArrayList<Observateur> observateurs = new ArrayList<>();

    public void attach(Observateur o);

    public void detach(Observateur o);
}
