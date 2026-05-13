package eticaret;

	public abstract class UrunDekorator extends Product {
	    protected Product dekoreEdilenUrun;

	    public UrunDekorator(Product urun) {
	        super(urun.isim, urun.fiyat);
	        this.dekoreEdilenUrun = urun;
	    }
	    public abstract double fiyatHesapla();
	    public abstract String adGetir();
	}

