package in.nexus_auth.banking_system;

import in.nexus_auth.banking_system.backend.BankingLoginSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingMain {
    public static void main(String[] args){
    SpringApplication.run(BankingMain.class,args);
    }
}
