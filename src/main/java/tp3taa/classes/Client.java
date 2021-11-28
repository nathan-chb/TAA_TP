package tp3taa.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp3taa.interfaces.*;

import java.util.List;

@Component
public class Client implements IRun, IClient {

    int numCompte = 1386432;
    String adresse = "25 rue Charles de Gaulle";

    @Autowired
    ILane ilane;
    @Autowired
    IFastLane iFastLane;
    @Autowired
    IJustHaveALook iJustHaveALook;

    @Override
    public void run() {
        System.out.println("===================================");
        System.out.println("Scenario 1 : ");
        iFastLane.oneShotOrder(4,"jambon", numCompte, adresse);
        System.out.println("===================================");
        System.out.println("Scenario 2 : ");
        ilane.addItemToCart("peanut butter", 2);
        ilane.addItemToCart("jelly", 2);
        ilane.addItemToCart("bread", 6);
        ilane.pay(numCompte);
        System.out.println("===================================");
    }
}
