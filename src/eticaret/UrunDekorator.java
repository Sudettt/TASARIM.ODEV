package eticaret;

public abstract class UrunDekorator extends Product {
    protected Product dekoreEdilenUrun;

    public UrunDekorator(Product urun) {
        super(urun.getName(), urun.getPrice()); 
        this.dekoreEdilenUrun = urun;
    }


    public abstract double getPrice();

    @Override
    public abstract String getName();
}