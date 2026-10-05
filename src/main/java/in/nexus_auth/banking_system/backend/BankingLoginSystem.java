package in.nexus_auth.banking_system.backend;

import com.MyLoginWeb.LoginSystem;
import com.MyLoginWeb.Person;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class BankingLoginSystem extends LoginSystem{
    private final UsrRepo usrRepo;;

    public void addUser(Person user, @Nullable String transaction_slip) {
        this.usrRepo.save(new UserRow(user.UserName(),this.getEncoder().encode(user.Password()),user.bio(),user.balance(),transaction_slip));
    }

    @Override
    public boolean loginByPassword(String Password, String UserName) {
       return this.getEncoder().matches(Password,this.usrRepo.findById(UserName).get().getPassword());
    }

    protected String getUserList1(){
     return super.getUserListAsString();
    }
    protected void updateUser(Person user,@Nullable String transaction_slip){
        this.usrRepo.save(new UserRow(user.UserName(),this.getEncoder().encode(user.Password()),user.bio(),user.balance(),transaction_slip));
    }
    public UserRow getUserInfo(String username){
        return this.usrRepo.findById(username).get();
    }

    @Autowired
    public BankingLoginSystem(UsrRepo usrrepo){
     this.usrRepo=usrrepo;
    }
}