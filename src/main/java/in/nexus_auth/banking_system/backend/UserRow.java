package in.nexus_auth.banking_system.backend;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "UserRows")
public class UserRow {
    @Id
    @Column(name = "username",nullable=false,unique = true)
    private String username;

    @Column(unique = false,nullable = false,name = "password")
    private String Password;

    @Column(unique = false,nullable = false,name = "usr_currency")
    private String usr_currency;

    @Column(name = "usr_balance",nullable = false,unique = false)
    private double usr_balance;

    @Column(name = "transaction_history",nullable = true,unique = false)
    private String transaction_history;
    public UserRow(){}

    public UserRow(String username, String password, String usr_currency, double usr_balance, @Nullable String transaction_history){
     this.username=username;
     this.Password=password;
     this.usr_currency=usr_currency;
     this.usr_balance=usr_balance;
     this.transaction_history = transaction_history;
    }

    protected String getUsername(){return this.username;}
    protected void setUsername(String username){this.username=username;}

    protected String getPassword(){return this.Password;}
    protected void setPassword(String Password){}

    public double getUsr_balance(){
        return this.usr_balance;
    }

    public String getTransaction_history(){
        return this.transaction_history;
    }
}
