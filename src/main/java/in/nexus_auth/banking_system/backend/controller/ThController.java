package in.nexus_auth.banking_system.backend.controller;

import com.MyLoginWeb.Person;
import in.nexus_auth.banking_system.backend.BankingLoginSystem;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.NoSuchElementException;

@Controller
public class ThController {
    private final BankingLoginSystem blsys;

    @GetMapping({"/","/home"})
    public String index(){
        return "index";
    }

    @PostMapping(value = "/username",name = "username")
    public String username(@RequestParam(name = "username")String Username , @RequestParam(name = "password")String password , @RequestParam(name ="isNew")@Nullable Boolean isNew, @RequestParam(name = "currency")String bio,Model model){
        System.out.println("CONTROLLER REACHED!!!");
        if(isNew==null){
           try{
               this.blsys.loginByPassword(password,Username);
               model.addAttribute("username",Username);
               model.addAttribute("usr_balance",Double.toString(this.blsys.getUserInfo(Username).getUsr_balance()));
               model.addAttribute("transaction_history",this.blsys.getUserInfo(Username).getTransaction_history());
               return "welcome_back";
           }catch(NoSuchElementException _){
             return "sorry";
           }
        }else{
            this.blsys.addUser(new Person(Username,password,bio,0),null);
            model.addAttribute("username",Username);
            model.addAttribute("usr_balance",Double.toString(0));
            model.addAttribute("transaction_history"," ---------- EMPTY -----------  ");
            return "welcome";
        }
    }

    @GetMapping("/userStats")
    public String username(Model model){
        return "userStats";
    }
    @Autowired
    public ThController(BankingLoginSystem loginSystem){
        System.out.println("LoginSytstem init in controller!!");
        this.blsys=loginSystem;
    }
}
