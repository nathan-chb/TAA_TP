package tp3taa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp3taa.interfaces.IRun;

@SpringBootApplication
public class Tp3Taa implements CommandLineRunner {


    @Autowired
    private IRun client;


    public void run(String... args) {
        client.run();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Tp3Taa.class, args);
    }

}