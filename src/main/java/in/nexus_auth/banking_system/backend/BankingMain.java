package in.nexus_auth.banking_system.backend;

import com.MyLoginWeb.Person;
import io.javalin.http.EnhanceYourCalmResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.SoundbankResource;
import java.util.Scanner;

@SpringBootApplication
public class BankingMain {
    @Autowired
    private static BankingLoginSystem loginSystem;

    public static void main(String[] args){
       ApplicationContext context= SpringApplication.run(BankingMain.class,args);
       loginSystem = context.getBean(BankingLoginSystem.class);
        Person person= new Person("AnkanDas56","ankandas@12",Currencies.INR.name(), (int)(Math.random()*50000));
        loginSystem.updateUser(person,null);
        if(loginSystem.loginByPassword(person.Password(),person.UserName())){
            System.out.println("Welcome to your very own bank account respected sir!");
            System.out.println("Please select an option- Transaction(type 'T') balance check (type 'B')");
            char usr_selection = new Scanner(System.in).next().charAt(0);
            if(usr_selection=='B') {
                System.out.println("You have selected balance check, lets see, \nyour balance is - " + loginSystem.getUserInfo(person.UserName()).getUsr_balance());
            }
        }
    }
   @Bean
    static CommandLineRunner run(BankingLoginSystem loginSystem){
        return args -> {
        };
    }

}
