package in.nexus_auth.banking_system.backend;

import com.MyLoginWeb.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingMain {
    public static void main(String[] args){
        BankingLoginSystem loginSystem = new BankingLoginSystem();
        TransactionManager mgr = new TransactionManager();
        Person JohnTheDon = new Person("JohnTheDon","KaunBanegaDon_JohnBanegaDon",null, (long) (Math.random()*500000)+100000);
        Person Ankan_Das =new Person("AnkanDas56", "ankubanku",null, (long) (Math.random() * 1000000) +500000) ;
        loginSystem.addUser(Ankan_Das);
        loginSystem.addUser(JohnTheDon);
        if(loginSystem.loginByPassword("ankubanku","AnkanDas56")){
            System.out.println("Before Transaction");
            System.out.println(loginSystem.getUserBio("ankubanku"));
        }
        if(loginSystem.loginByPassword(JohnTheDon.Password(),JohnTheDon.UserName())){
            mgr.transact(JohnTheDon,Ankan_Das,25999,loginSystem);
            System.out.println("After Transaction (For some valuable 'MSG' ;) )");
        }

        if(loginSystem.loginByPassword("ankubanku","AnkanDas56")){
            System.out.println(loginSystem.getUserBio("ankubanku"));
        }
        //SpringApplication.run(BankingMain.class,args);
    }
}
