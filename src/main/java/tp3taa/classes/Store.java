package tp3taa.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp3taa.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Store implements IJustHaveALook, IFastLane, ILane, IStore {

    int compteMagasin = 248463;
    String adresseMagasin = ("10 rue du paradis");

    List<String> panier = new ArrayList<String>();

    @Autowired
    Ibank ibank;

    @Autowired
    IProvider iProvider;

    @Override
    public void oneShotOrder(int quant, String article, int numCompte, String adresse) {
        int prix = getPrice(article, false) * quant;
        if(isAvailable(article, quant)){
            System.out.println("\nprix total pour "+ quant + " " + article + " : " + prix);
            ibank.transfert(String.valueOf(numCompte), String.valueOf(compteMagasin), prix);
            if(!isAvailable(article,1)){
                System.out.print("\nle stock de l'article " + article +" est épuisé, reapprovisionement en cours...");
                iProvider.order(100, article, compteMagasin, adresseMagasin);
                int prix2 = 100 * iProvider.getPrice(article, false);
                ibank.transfert(String.valueOf(compteMagasin), String.valueOf("12973961"), prix2);

            }
        }else{
            System.out.println("\nl'article " + article +"(x"+ quant + ") n'est pas disponible dans la quantité demandée");
            iProvider.order(100, article, compteMagasin, adresseMagasin);
            int prix2 = 100 * iProvider.getPrice(article, false);
            ibank.transfert(String.valueOf(compteMagasin), String.valueOf("12973961"), prix2);
            System.out.println("\nprix total pour "+ quant + " " + article + " : " + prix);
            ibank.transfert(String.valueOf(numCompte), String.valueOf(compteMagasin), prix);
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
        if (Math.random() > 0.5) { return true; } else { return false; }
    }

    @Override
    public void addItemToCart(String article, int quant) {
        if(isAvailable(article, quant)){
            for(int i = 0; i < quant; i++) {
                panier.add(article);
            }
            System.out.println("\nl'article " + article +"(x"+ quant + ") a bien été ajouté à votre panier");
        }else{
            System.out.println("\nl'article " + article +"(x"+ quant + ") n'est pas disponible dans la quantité demandée");
            iProvider.order(100, article, compteMagasin, adresseMagasin);
            int prix = 100 * iProvider.getPrice(article, false);
            ibank.transfert(String.valueOf(compteMagasin), String.valueOf("12973961"), prix);
            for(int i = 0; i < quant; i++) {
                panier.add(article);
            }
            System.out.println("\nl'article " + article +"(x"+ quant + ") a bien été ajouté à votre panier");
        }
    }

    @Override
    public void pay(int numCompte) {
        int prixPanier = 0;
        for(String article : panier){
            prixPanier += getPrice(article, false);
            if(!isAvailable(article,1)){
                System.out.print("\nle stock de l'article " + article +" est épuisé, reapprovisionement en cours...");
                iProvider.order(100, article, compteMagasin, adresseMagasin);
                int prix2 = 100 * iProvider.getPrice(article, false);
                ibank.transfert(String.valueOf(compteMagasin), String.valueOf("12973961"), prix2);

            }
        }
        panier.clear();
        ibank.transfert(String.valueOf(numCompte), String.valueOf(compteMagasin), prixPanier);

    }
}
