package eticaret;

public class OdemeAdaptoru {
    private DisBankaServisi bankaServisi;

    public OdemeAdaptoru() {
        this.bankaServisi=new DisBankaServisi();
    }

    public void ode(double miktar) {
        bankaServisi.tahsilatGerceklestir(miktar);
    }
}