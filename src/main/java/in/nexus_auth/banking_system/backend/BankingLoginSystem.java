package in.nexus_auth.banking_system.backend;

import com.MyLoginWeb.LoginSystem;
import com.MyLoginWeb.Person;
import java.util.HashMap;

public class BankingLoginSystem extends LoginSystem {
    private final HashMap<String,Person> userInfos = new HashMap<>();
    @Override
    public String addUser(String User_Name, String accountNo) {
        return super.addUser(User_Name, accountNo);
    }

    @Override
    public void addUser(Person user) {
        this.userInfos.put(user.Password(),user);
        super.addUser(user);
    }

    @Override
    public String getUserListAsString(){
     return super.getUserListAsString();
    }
    protected String getUserBio(String password){
        return this.userInfos.get(password).UserName()+" - A/C balance - "+this.userInfos.get(password).balance();
    }
    protected void updateUser(Person user){
        this.userInfos.replace(user.Password(),this.userInfos.get(user.Password()),user);
    }

}