package eticaret;

public class HediyePaketi extends UrunDekorator {
    public HediyePaketi(Product urun) {
        super(urun);
    }

    @Override
    public double getPrice() {
        return dekoreEdilenUrun.getPrice()+20.0;
    }

    @Override
    public String getName() {
        return dekoreEdilenUrun.getName() + " (Hediye Paketli)";
    }
}