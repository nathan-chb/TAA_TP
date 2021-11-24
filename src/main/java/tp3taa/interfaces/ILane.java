package tp3taa.interfaces;

public interface ILane extends IStore{
    public void addItemToCart(String article, int quant);
    public void pay(int numCompte);
}
