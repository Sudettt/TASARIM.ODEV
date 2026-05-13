package eticaret;

public class OgrenciIndirimi implements Discount {
	    @Override
	    public double IndirimUygula(double miktar) {
	        return miktar * 0.85; 
	    }
	}

