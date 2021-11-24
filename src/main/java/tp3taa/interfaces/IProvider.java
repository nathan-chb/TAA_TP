package tp3taa.interfaces;

public interface IProvider {
    public int getPrice(String article, boolean syslog);
    public void order(int quant, String article, int numCompte, String adresse);
}
