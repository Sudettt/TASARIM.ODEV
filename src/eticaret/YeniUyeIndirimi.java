package eticaret;

public class YeniUyeIndirimi implements Discount {
	@Override
    public double IndirimUygula(double miktar) {
        return miktar * 0.90; 
    }
}
