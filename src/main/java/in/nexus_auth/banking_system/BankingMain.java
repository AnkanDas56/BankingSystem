package in.nexus_auth.banking_system;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.gson.JsonParser;

import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class BankingMain {
    public static void main(String[] args){
        try{
            String json = Files.readString(Path.of("test.json"));
            System.out.println(JsonParser.parseString(json).getAsJsonObject().get("Lives").getAsJsonObject().get("Me").getAsJsonObject().get("Name"));
        } catch (Exception e) {
            System.out.println("didn't work");
        }
    }
}
