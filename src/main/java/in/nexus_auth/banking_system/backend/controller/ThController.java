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

@Controller
public class ThController {
    @Autowired
    private BankingLoginSystem blsys;
    private Model model;
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @PostMapping(value = "/username",name = "username")
    public String username(@RequestParam(name = "username")String Username , @RequestParam(name = "password")String password , @RequestParam(name ="isNew")@Nullable Boolean isNew, @RequestParam(name = "currency")String bio,Model Model){
        if(Boolean.TRUE.equals(isNew)){
            this.blsys.addUser(new Person(Username,password,bio,0));
            this.model.addAttribute("username",Username);
            return "welcome";
        } else if (isNew==null) {
            if(this.blsys.loginByPassword(password,Username)){
                this.model=Model;
                this.model.addAttribute("username",Username);
                this.model.addAttribute("transaction_history",this.blsys.getUserInfo(Username).getTransaction_history());
                this.model.addAttribute("usrBalance",Double.toString(this.blsys.getUserInfo(Username).getUsr_balance()));
                Model=this.model;
                return "welcome_back";
            }
        }
        return "index";
    }
    @GetMapping("/userStats")
    public String username(Model Model){
    Model=this.model;
        System.out.println(this.blsys.getUserInfo(this.model.getAttribute("username").toString()).getUsr_balance());
        return "userStats";
    }
    @Autowired
    public ThController(BankingLoginSystem loginSystem){
        this.blsys=loginSystem;
    }
}
