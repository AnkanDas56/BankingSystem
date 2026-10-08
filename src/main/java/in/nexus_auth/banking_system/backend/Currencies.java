package in.nexus_auth.banking_system.backend;

public enum Currencies {
    //we just set the rate for the USD by that currency and ,it works completely fine!
    USD(1),
    INR(80),
    CFA_Franc(120),
    ;
    double USD_RATE;
    Currencies(int i) {
        this.USD_RATE=i;
    }
    public double getUSD_Rate(){
        return this.USD_RATE;
    }
}
