package eticaret;

public class TopluAlimIndirimi implements Discount {

	@Override
    public double IndirimUygula(double miktar) {
        if (miktar>1000) {
            return miktar*0.80; 
        }
        return miktar;
    }

}
