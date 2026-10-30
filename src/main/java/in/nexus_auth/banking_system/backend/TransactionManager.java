package in.nexus_auth.banking_system.backend;

import com.MyLoginWeb.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TransactionManager {
    private UsrRepo repo;
 protected void transact(Person from, Person to, double amount, BankingLoginSystem blsys){
       if((from.balance()-amount)>=0&&amount>0) {
           String transaction_history= this.repo.findById(from.UserName()).get().getTransaction_history();
           from = new Person(from.UserName(), from.Password(), from.bio(), from.balance() - amount);
           blsys.updateUser(from, transaction_history+" \nDEBITED " + amount + " " + from.bio() + " TO TRANSACT TO " + to.UserName());
           //here, to make currencies fair for everyone, I found a coefficient of the USD rates of the currencies of guy sending the money and the of guy receiving the money
           // When we multiply this coefficient by the amount, the person who is receiving, receives the correct exchanged amount, this coefficient works for every transaction, lets say, sender is USD, receiver is INR,
           // The coefficient is equal to TO_USD_RATE/FROM_USD_RATE so, lets say current USD rate for INR is 80, it will be, 80/1 so, the receiver gets amount*80 INR.
           transaction_history=this.repo.findById(to.UserName()).get().getTransaction_history();
           to = new Person(to.UserName(), to.Password(), to.bio(), to.balance() + amount * (Currencies.valueOf(to.bio()).getUSD_Rate() / Currencies.valueOf(from.bio()).getUSD_Rate()));
           blsys.updateUser(to,transaction_history+"\nCREDITED"+amount * (Currencies.valueOf(to.bio()).getUSD_Rate() / Currencies.valueOf(from.bio()).getUSD_Rate())+"FROM "+to.UserName());
           System.out.println(from.UserName() + " paid " + amount + " to " + to.UserName());
           blsys=null;
           from=null;
           to=null;
           transaction_history=null;
       }else System.out.println("Sorry, please check your requested transaction amount and your bank balance");
 }
 @Autowired
 public TransactionManager(UsrRepo repo){
     this.repo=repo;
 }
}
