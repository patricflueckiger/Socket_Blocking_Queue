package src.Server;

import java.util.Observable;
import java.util.Observer;

public interface ObserverInterface extends Observer {

    @Override
    void update(Observable o, Object arg);
}
