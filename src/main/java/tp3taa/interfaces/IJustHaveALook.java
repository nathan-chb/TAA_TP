package tp3taa.interfaces;

public interface IJustHaveALook extends IStore{
    public int getPrice(String article, boolean syslog);
    public boolean isAvailable(String article, int quant);
}
