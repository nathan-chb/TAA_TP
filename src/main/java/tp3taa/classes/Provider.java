package tp3taa.classes;

import org.springframework.stereotype.Component;
import tp3taa.interfaces.IProvider;

@Component
public class Provider implements IProvider {

    @Override
    public int getPrice(String article, boolean syslog) {
        int res = article.length() * 10;
        if(syslog) {
            System.out.println("\nl'article " + article + " coute " + res + "$");
        }
        return res;
    }

    @Override
    public void order(int quant, String article, int numCompte, String adresse) {

        System.out.println("\n Le magasin a été réaprovisionné : " + article + "(x" + quant + ")");
    }
}
