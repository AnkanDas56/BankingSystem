package in.nexus_auth.banking_system.backend;

import com.MyLoginWeb.LoginSystem;
import com.MyLoginWeb.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

@SpringBootApplication
public class BankingMain {
    public static void main(String[] args){
        LoginSystem loginSystem = new BankingLoginSystem();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("ankubanku");
        loginSystem.addUser(new Person("AnkanDas56", "ankubanku","HELLO!"));
        if(!loginSystem.loginByPassword("ankubanku","AnkanDas56")){
            System.out.println("HELLO!");
        }
        SpringApplication.run(BankingMain.class,args);
    }
}
