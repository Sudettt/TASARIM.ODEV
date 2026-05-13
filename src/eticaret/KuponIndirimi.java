package eticaret;

public class KuponIndirimi implements Discount{
	@Override
    public double IndirimUygula(double miktar) {
        return miktar-50;
    }
}

