package eticaret;

public class BankaOdemeStratejisi implements OdemeStratejisi {
    private OdemeAdaptoru adaptor;

    public BankaOdemeStratejisi() {
        this.adaptor=new OdemeAdaptoru();
    }

    @Override
    public void ode(double miktar) {
        adaptor.ode(miktar);
    }
}