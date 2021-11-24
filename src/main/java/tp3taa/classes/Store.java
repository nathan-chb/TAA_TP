package tp3taa.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp3taa.interfaces.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class Store implements IJustHaveALook, IFastLane, ILane, IStore {

    int compteMagasin = 248463;
    String adresseMagasin = ("10 rue renaud Lavillenie");

    List<String> panier = new ArrayList<String>();

    @Autowired
    Ibank ibank;

    @Autowired
    IProvider iProvider;

    @Override
    public void oneShotOrder(int quant, String article, int numCompte, String adresse) {
        if(isAvailable(article, quant)){
            int prix = getPrice(article, false) * quant;
            System.out.println("\nprix total pour "+ quant + " " + article + " : " + prix);
            ibank.transfert(String.valueOf(numCompte), String.valueOf(compteMagasin), prix);
            //TODO mettre a jour le stock
        }else{
            System.out.println("\nl'article " + article +"(x"+ quant + ") n'est pas disponible dans la quantité demandée");
            iProvider.order(100, article, compteMagasin, adresseMagasin);
            int prix = quant * iProvider.getPrice(article, false);
            ibank.transfert(String.valueOf(compteMagasin), String.valueOf("12973961"), prix);
        }

    }

    @Override
    public int getPrice(String article, boolean syslog) {
        int res = article.length() * 10;
        if(syslog) {
            System.out.println("\nl'article " + article + " coute " + res + "$");
        }
        return res;
    }

    @Override
    public boolean isAvailable(String article, int quant) {
        if ( (quant & 1) == 0 ) { return true; } else { return false; }
    }

    @Override
    public void addItemToCart(String article, int quant) {
        if(isAvailable(article, quant)){
            System.out.println("\nl'article " + article +"(x"+ quant + ") a bien été ajouté à votre panier");
            for(int i = 0; i < quant; i++) {
                panier.add(article);
            }
        }else{
            System.out.println("\nl'article " + article +"(x"+ quant + ") n'est pas disponible dans la quantité demandée");
            iProvider.order(100, article, compteMagasin, adresseMagasin);
            int prix = quant * iProvider.getPrice(article, false);
            ibank.transfert(String.valueOf(compteMagasin), String.valueOf("12973961"), prix);
        }
    }

    @Override
    public void pay(int numCompte) {
        int prixPanier = 0;
        for(String article : panier){
            prixPanier += getPrice(article, false);
        }
        panier.clear();
        ibank.transfert(String.valueOf(numCompte), String.valueOf(compteMagasin), prixPanier);

    }
}
