package eticaret;

public class NakitOdemeStratejisi implements OdemeStratejisi {
    @Override
    public void ode(double miktar) {
        System.out.println(miktar + " TL nakit olarak (kapıda ödeme) tahsil edilecek.");
    }
}