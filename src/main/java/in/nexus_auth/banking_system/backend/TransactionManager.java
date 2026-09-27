package in.nexus_auth.banking_system.backend;

import com.MyLoginWeb.Person;

public class TransactionManager {
 protected void transact(Person from, Person to, long amount,BankingLoginSystem blsys){
       if((from.balance()-amount)>=0)
       from = new Person(from.UserName(), from.Password(),from.bio(),from.balance()-amount);
       blsys.updateUser(from);
       to = new Person(to.UserName(),to.Password(),to.bio(),to.balance()+amount);
       blsys.updateUser(to);
       System.out.println(from.UserName()+" paid "+amount+" to "+to.UserName());
 }
}
