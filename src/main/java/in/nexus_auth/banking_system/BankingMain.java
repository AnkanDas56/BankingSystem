package in.nexus_auth.banking_system;

import com.MyLoginWeb.Person;
import in.nexus_auth.banking_system.backend.BankingLoginSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingMain {
    private static final Logger log = LoggerFactory.getLogger(BankingMain.class);
    @Autowired
    private static BankingLoginSystem loginSystem;

    public static void main(String[] args){
       ApplicationContext context = SpringApplication.run(BankingMain.class,args);
       loginSystem=context.getBean(BankingLoginSystem.class);
    }
   @Bean
    static CommandLineRunner run(BankingLoginSystem loginSystem){
        return args -> {
            Person person = new Person("AnkanDas56","ankandas@12","USD",(Math.random()*200000));
            loginSystem.updateUser(person,null);
        };
    }
    public static BankingLoginSystem getLoginSystem(){
        return loginSystem;
    }
}
