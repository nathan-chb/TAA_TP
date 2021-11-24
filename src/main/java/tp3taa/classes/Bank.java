package tp3taa.classes;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Component;
import tp3taa.interfaces.Ibank;

@Component
public class Bank implements Ibank {
    @Override
    public void transfert(String emmeteur, String destinataire, int quant) {
        System.out.println("\n" + quant + "$ ont été transférés depuis le compte " + emmeteur + " vers le compte " + destinataire);
    }
}
