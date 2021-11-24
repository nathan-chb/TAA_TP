package tp3taa.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp3taa.interfaces.*;

import java.util.List;

@Component
public class Client implements IRun, IClient {

    int numCompte = 1386432;

    @Autowired
    ILane ilane;
    @Autowired
    IFastLane iFastLane;
    @Autowired
    IJustHaveALook iJustHaveALook;

    @Override
    public void run() {
        iJustHaveALook.getPrice("mozzarella", true);
        ilane.addItemToCart("mozzarella", 5);
        ilane.addItemToCart("jambon", 2);
        ilane.pay(numCompte);
    }
}
